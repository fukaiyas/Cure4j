package cure4j.girls;

import cure4j.internal.GirlsLoader;
import cure4j.util.LinkleStone;
import cure4j.util.LinkleStoneMiracleMagical;
import cure4j.util.PrecureColor;
import cure4j.util.Listream;

import java.time.LocalDate;
import java.util.*;

public abstract class Girl {

    public static long sleepSec = 1;

    protected final String humanName;
    protected final String humanFullName;
    protected final String castName;
    protected final String birthday;
    protected final Listream<String> extraNames;
    protected final Listream<String> transformCalls;

    protected final List<String> allNames = new ArrayList<>();

    protected int current = 0;

    public Girl(Map<String, Object> config) {
        this.humanName = (String)config.get("human_name");
        this.humanFullName = (String)config.get("human_full_name");
        this.castName = (String)config.get("cast_name");
        this.birthday = (String)config.get("birthday");
        this.extraNames = new Listream<String>((List<String>)config.get("extra_names"));
        this.transformCalls = new Listream<String>((List<String>)config.get("transform_calls"));
    }

    public static <T extends Girl> T byName(String girlName){
        return(T) GirlsLoader.get(girlName);
    }

    public abstract String girlName();

    public abstract String precureName();

    public abstract PrecureColor color();

    public abstract LocalDate createdDate();

    public String humanName() {
        return humanName;
    }

    public String humanFullName() {
        return humanFullName;
    }

    public String castName() {
        return castName;
    }

    public String birthday() {
        return birthday;
    }

    public Listream<String> extraNames(){
        return extraNames;
    }

    public Listream<String> transformCalls(){
        return transformCalls;
    }

    public abstract String transformMessage();

    public abstract Listream<String> attackMessages();

    public String name(){
        return allNames.get(current);
    }

    public boolean hasBirthday(){
        return birthday != null;
    }

    public Girl humanize(){
        current = 0;
        return this;
    }

    public void attack(){
        if(current == 0){
            throw new RequireTransformException("Require transform.");
        }
        printByLine(attackMessages().get(current - 1));
    }

    @Override
    public String toString(){
        return name();
    }

    protected void printByLine(String message){
        Arrays.stream(message.split("\\n"))
                .forEachOrdered(Girl::sleepAndPrint);
    }

    private static void sleepAndPrint(String message){
        try {
            Thread.sleep(sleepSec * 1000);
        } catch (InterruptedException e) {
            //ignore
        }
        System.out.println(message);
    }

    public static class StandardGirl extends Girl{

        protected final String girlName;
        protected final String precureName;
        protected final PrecureColor color;
        protected final LocalDate createdDate;
        protected final String transformMessage;
        protected final Listream<String> attackMessages;

        public StandardGirl(Map<String, Object> config){
            super(config);
            this.girlName = (String)config.get("girl_name");
            this.precureName = (String)config.get("precure_name");
            this.createdDate = (LocalDate)config.get("created_date");
            this.color = PrecureColor.valueOf(config.get("color").toString().toUpperCase());
            this.transformMessage = (String)config.get("transform_message");
            this.attackMessages = new Listream<String>((List<String>)config.get("attack_messages"));

            allNames.add(this.humanName);
            allNames.add(this.precureName);
            allNames.addAll(this.extraNames);
        }

        @Override
        public String girlName() {
            return girlName;
        }

        @Override
        public String precureName() {
            return precureName;
        }

        @Override
        public PrecureColor color() {
            return color;
        }

        @Override
        public LocalDate createdDate() {
            return createdDate;
        }

        @Override
        public String transformMessage() {
            return transformMessage;
        }

        @Override
        public Listream<String> attackMessages() {
            return attackMessages;
        }

        public StandardGirl transform(){
            current = (current + 1) % allNames.size();
            if(current == 1){
                printByLine(transformMessage);
            }
            return this;
        }

        @Override
        public int hashCode(){
            return girlName.hashCode();
        }
        @Override
        public boolean equals(Object other){
            if(other == null || !(other instanceof StandardGirl)){
                return false;
            }
            StandardGirl otherGirl = (StandardGirl)other;
            return girlName.equals(otherGirl.girlName);
        }
    }

    public static class MahoGirl extends Girl{

        protected final Listream<String> girlNames;
        protected final Listream<String> precureNames;
        protected final Listream<PrecureColor> colors;
        protected final Listream<LocalDate> createdDates;
        protected final Listream<String> transformMessages;
        protected final Listream<String> attackMessages;

        public MahoGirl(Map<String, Object> config, LinkleStone[] linkleStones){
            super(config);
            Map<String, Object> styles = (Map<String, Object>)config.get("transform_styles");
            List<String> girlNamesList = new ArrayList<>();
            List<String> precureNamesList = new ArrayList<>();
            List<PrecureColor> colorsList = new ArrayList<>();
            List<LocalDate> createdDatesList = new ArrayList<>();
            List<String> transformMessagesList = new ArrayList<>();
            List<String> attackMessagesList = new ArrayList<>();
            //変身前(index=0)
            girlNamesList.add((String)config.get("girl_name"));
            precureNamesList.add((String)config.get("precure_name"));
            PrecureColor defaultColor = PrecureColor.valueOf(config.get("color").toString().toUpperCase());
            colorsList.add(defaultColor);
            createdDatesList.add((LocalDate)config.get("created_date"));
            transformMessagesList.add("");//変身前なのでない
            //attack_messageはインデックス調整が入るので変身前用は不要
            //変身後 LinkleStoneで指定したindex順に保持
            Arrays.stream(linkleStones)
                    .sorted((l1, l2) -> l1.index() - l2.index())
                    .map(l -> (Map<String, Object>)styles.get(l.configKey()))
                    .forEachOrdered(m -> {
                        girlNamesList.add((String)m.get("girl_name"));
                        precureNamesList.add((String)m.get("precure_name"));
                        String color = (String)m.get("color");
                        colorsList.add(color == null ? defaultColor : PrecureColor.valueOf(color.toUpperCase()));
                        createdDatesList.add((LocalDate)m.get("created_date"));
                        transformMessagesList.add((String)m.get("transform_message"));
                        attackMessagesList.addAll((List<String>)m.get("attack_messages"));
                        //attack_messages はListだが、まほプリではそれぞれ1要素ずつとして決め打ちしている
                        //場合によっては、List<List<String>>にする必要があるかもしれない
                    });
            this.girlNames = new Listream<>(girlNamesList);
            this.precureNames = new Listream<>(precureNamesList);
            this.colors = new Listream<>(colorsList);
            this.createdDates = new Listream<>(createdDatesList);
            this.transformMessages = new Listream<>(transformMessagesList);
            this.attackMessages = new Listream<>(attackMessagesList);

            allNames.addAll(this.precureNames);
            allNames.set(0, this.humanName);//素のプリキュア名はname()メソッドでは使わない
        }

        @Override
        public String girlName() {
            return girlNames.get(current);
        }

        @Override
        public String precureName() {
            return precureNames.get(current);
        }

        @Override
        public PrecureColor color() {
            return colors.get(current);
        }

        @Override
        public LocalDate createdDate() {
            return createdDates.get(current);
        }

        @Override
        public Listream<String> attackMessages() {
            return attackMessages;
        }

        @Override
        public String transformMessage() {
            return transformMessages.get(current);
        }

        protected void transform(LinkleStone linkleStone){
            current = linkleStone.index();
            printByLine(transformMessages.get(current));
        }

        @Override
        public int hashCode(){
            return girlNames.hashCode();
        }
        @Override
        public boolean equals(Object other){
            if(other == null || !(other instanceof MahoGirl)){
                return false;
            }
            MahoGirl otherGirl = (MahoGirl)other;
            return girlNames.equals(otherGirl.girlNames);
        }
    }
}
