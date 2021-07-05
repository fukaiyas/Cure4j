package cure4j.girls;

import cure4j.internal.GirlsLoader;
import cure4j.util.LinkleStone;
import cure4j.util.PrecureColor;
import cure4j.util.Listream;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public abstract class Girl <G extends Girl<G>>{

    public static double sleepSec = 1;
    public static MessagePrinter messagePrinter = new MessagePrinter();

    protected final String humanName;
    protected final Optional<String> humanFullName;
    protected final String castName;
    protected final Optional<String> birthday;
    protected final Listream<String> extraNames;
    protected final Listream<String> transformCalls;

    protected final List<String> allNames = new ArrayList<>();

    protected int current = 0;

    public Girl(Map<String, Object> config) {
        this.humanName = (String)config.get("human_name");
        this.humanFullName = Optional.ofNullable((String)config.get("human_full_name"));
        this.castName = (String)config.get("cast_name");
        this.birthday = Optional.ofNullable((String)config.get("birthday"));
        this.extraNames = new Listream<String>((List<String>)config.get("extra_names"));
        this.transformCalls = new Listream<String>((List<String>)config.get("transform_calls"));
    }

    public static Listream<Girl<?>> allGirls(){
        return GirlsLoader.getAllGirls();
    }

    public static <T extends Girl<?>> T byName(String girlName){
        return(T) GirlsLoader.get(girlName);
    }

    public abstract String girlName();

    public abstract String precureName();

    public abstract PrecureColor color();

    public abstract LocalDate createdDate();

    public LocalDate firstCreatedDate(){
        return createdDate();
    }

    public String fullName() {
        return humanFullName.orElse(humanName);
    }

    public String humanName() {
        return humanName;
    }

    public String humanFullName() {
        return humanFullName.orElse("Undefined.");
    }

    public String castName() {
        return castName;
    }

    public String birthday() {
        return birthday.orElse("No official data.");
    }

    public Listream<String> getExtraNames(){
        return extraNames;
    }

    public Listream<String> getTransformCalls(){
        return transformCalls;
    }

    public abstract String getTransformMessage();

    public abstract Listream<String> getAttackMessages();

    public String name(){
        return allNames.get(current);
    }

    public boolean hasBirthday(){
        return birthday.isPresent();
    }

    public G humanize(){
        current = 0;
        return (G)this;
    }

    public void attack(){
        if(current == 0){
            throw new RequireTransformException("Require transform.");
        }
        printByLine(getAttackMessages().get(Math.min(current, getAttackMessages().size()) - 1));
    }

    @Override
    public String toString(){
        return name();
    }

    protected void printByLine(String message){
        Arrays.stream(message.split("\\n"))
                .forEachOrdered(ms -> messagePrinter.sleepAndPrintln(sleepSec, ms));
    }

    public static class StandardGirl<G extends StandardGirl<G>> extends Girl<StandardGirl<G>>{

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
        public String getTransformMessage() {
            return transformMessage;
        }

        @Override
        public Listream<String> getAttackMessages() {
            return attackMessages;
        }

        public G transform(){
            current = (current + 1) % allNames.size();
            if(current == 1){
                printByLine(transformMessage);
            }
            return (G)this;
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
            StandardGirl<?> otherGirl = (StandardGirl<?>)other;
            return girlName.equals(otherGirl.girlName);
        }
    }

    public static class MahoGirl<G extends MahoGirl<G>> extends Girl<MahoGirl<G>>{

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
            List<String> colorsList = new ArrayList<>();
            List<LocalDate> createdDatesList = new ArrayList<>();
            List<String> transformMessagesList = new ArrayList<>();
            List<String> attackMessagesList = new ArrayList<>();
            //変身前(index=0)
            girlNamesList.add((String)config.get("girl_name"));
            precureNamesList.add((String)config.get("precure_name"));
            colorsList.add((String)config.get("color"));
            createdDatesList.add((LocalDate)config.get("created_date"));
            transformMessagesList.add("");//変身前なのでない
            //attack_messageはインデックス調整が入るので変身前用は不要
            //変身後 LinkleStoneで指定したindex順に保持
            Arrays.stream(linkleStones)
                    .sorted((l1, l2) -> l1.index() - l2.index())
                    .map(l -> (Map<String, Object>)styles.get(l.configKey()))
                    .forEachOrdered(m -> {
                        girlNamesList.add((String)m.get("girl_name"));
                        precureNamesList.add((String)m.getOrDefault("precure_name", precureNamesList.get(0)));
                        colorsList.add((String)m.getOrDefault("color", colorsList.get(0)));
                        createdDatesList.add((LocalDate)m.getOrDefault("created_date", createdDatesList.get(0)));
                        transformMessagesList.add((String)m.get("transform_message"));
                        attackMessagesList.addAll((List<String>)m.get("attack_messages"));
                        //attack_messages はListだが、まほプリではそれぞれ1要素ずつとして決め打ちしている
                        //場合によっては、List<List<String>>にする必要があるかもしれない
                    });
            this.girlNames = new Listream<>(girlNamesList);
            this.precureNames = new Listream<>(precureNamesList);
            this.colors = new Listream<>(
                    colorsList.stream()
                            .map(c -> PrecureColor.valueOf(c.toUpperCase()))
                            .collect(Collectors.toList()));
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
        public LocalDate firstCreatedDate(){
            return createdDates.get(0);
        }

        @Override
        public Listream<String> getAttackMessages() {
            return attackMessages;
        }

        @Override
        public String getTransformMessage() {
            return transformMessages.get(current);
        }

        protected G transform(LinkleStone linkleStone){
            current = linkleStone.index();
            printByLine(transformMessages.get(current));
            return (G)this;
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

    public static class MessagePrinter {
        public void sleepAndPrintln(double sec, String message){
            try {
                Thread.sleep((long)(sec * 1000.0));
            } catch (InterruptedException e) {
                //ignore
            }
            System.out.println(message);
        }
    }
}
