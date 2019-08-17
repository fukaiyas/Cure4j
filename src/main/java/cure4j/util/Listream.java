package cure4j.util;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Listream<T> implements List<T>, Stream<T> {
//TODO default実装されているメソッドを調べて必要ならオーバーライド
    protected List<T> list;
    protected Stream<T> stream;

    public Listream(){
        this(new ArrayList<>());
    }
    public Listream(List<? extends T>... lists){
        this.list = Arrays.stream(lists)
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());
    }
    public Listream(List<? extends T> list){
        this.list = list == null ? new ArrayList<>() : new ArrayList<>(list);
    }
    private Listream(Stream<T> stream){
        this.stream = stream;
    }

    protected List<T> ls(){
        if(list == null){
            list = stream.collect(Collectors.toList());
            stream = null;
        }
        return list;
    }
    protected Stream<T> st(){
        return stream == null ? list.stream() : stream;
    }
    protected <S> Listream<S> st(Function<Stream<T>, Stream<S>> streamFunction){
        Stream<T> st = stream == null ? list.stream() : stream;
        return wrap(streamFunction.apply(st));
    }

    protected void invoke(
            Consumer<List<T>> listInvoker,
            Consumer<Stream<T>> streamConsumer){
        if(list == null){
            streamConsumer.accept(stream);
        }else{
            listInvoker.accept(list);
        }
    }
    protected <T1> Listream<T1> wrap(List<T1> ls){
        return new Listream<>(ls);
    }
    protected <T1> Listream<T1> wrap(Stream<T1> st){
        return new Listream<>(st);
    }

    @Override
    public int size() {
        return ls().size();
    }

    @Override
    public boolean isEmpty() {
        return ls().isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return ls().contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return ls().iterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        invoke(ls -> ls.forEach(action), st -> st.forEach(action));
    }

    @Override
    public boolean isParallel() {
        //Don't support parallel stream.
        return false;
    }

    @Override
    public Listream<T> sequential() {
        return this;
    }

    @Override
    public Listream<T> parallel() {
        throw new UnsupportedOperationException("Don't support parallel stream.");
    }

    @Override
    public Listream<T> unordered() {
        return st(Stream::unordered);
    }

    @Override
    public Listream<T> onClose(Runnable closeHandler) {
        return st(s -> s.onClose(closeHandler));
    }

    @Override
    public void close() {
        st().close();
    }

    @Override
    public Listream<T> filter(Predicate<? super T> predicate) {
        return st(s -> s.filter(predicate));
    }

    @Override
    public <R> Listream<R> map(Function<? super T, ? extends R> mapper) {
        return st(s -> s.map(mapper));
    }

    @Override
    public IntStream mapToInt(ToIntFunction<? super T> mapper) {
        return st().mapToInt(mapper);
    }

    @Override
    public LongStream mapToLong(ToLongFunction<? super T> mapper) {
        return st().mapToLong(mapper);
    }

    @Override
    public DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper) {
        return st().mapToDouble(mapper);
    }

    @Override
    public <R> Listream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) {
        return st(s -> s.flatMap(mapper));
    }

    @Override
    public IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper) {
        return st().flatMapToInt(mapper);
    }

    @Override
    public LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper) {
        return st().flatMapToLong(mapper);
    }

    @Override
    public DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper) {
        return st().flatMapToDouble(mapper);
    }

    @Override
    public Listream<T> distinct() {
        return st(Stream::distinct);
    }

    @Override
    public Listream<T> sorted() {
        return st(Stream::sorted);
    }

    @Override
    public Listream<T> sorted(Comparator<? super T> comparator) {
        return st(s -> sorted(comparator));
    }

    @Override
    public Listream<T> peek(Consumer<? super T> action) {
        return st(s -> s.peek(action));
    }

    @Override
    public Listream<T> limit(long maxSize) {
        return st(s -> s.limit(maxSize));
    }

    @Override
    public Listream<T> skip(long n) {
        return st(s -> s.skip(n));
    }

    @Override
    public Listream<T> takeWhile(Predicate<? super T> predicate) {
        return st(s -> s.takeWhile(predicate));
    }

    @Override
    public Listream<T> dropWhile(Predicate<? super T> predicate) {
        return st(s -> s.dropWhile(predicate));
    }

    @Override
    public void forEachOrdered(Consumer<? super T> action) {
        st().forEachOrdered(action);
    }

    @Override
    public Object[] toArray() {
        return ls().toArray();
    }

    @Override
    public T reduce(T identity, BinaryOperator<T> accumulator) {
        return st().reduce(identity, accumulator);
    }

    @Override
    public Optional<T> reduce(BinaryOperator<T> accumulator) {
        return st().reduce(accumulator);
    }

    @Override
    public <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner) {
        return st().reduce(identity, accumulator, combiner);
    }

    @Override
    public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner) {
        return st().collect(supplier, accumulator, combiner);
    }

    @Override
    public <R, A> R collect(Collector<? super T, A, R> collector) {
        return st().collect(collector);
    }

    @Override
    public Optional<T> min(Comparator<? super T> comparator) {
        return st().min(comparator);
    }

    @Override
    public Optional<T> max(Comparator<? super T> comparator) {
        return st().max(comparator);
    }

    @Override
    public long count() {
        return st().count();
    }

    @Override
    public boolean anyMatch(Predicate<? super T> predicate) {
        return st().anyMatch(predicate);
    }

    @Override
    public boolean allMatch(Predicate<? super T> predicate) {
        return st().allMatch(predicate);
    }

    @Override
    public boolean noneMatch(Predicate<? super T> predicate) {
        return st().noneMatch(predicate);
    }

    @Override
    public Optional<T> findFirst() {
        return st().findFirst();
    }

    @Override
    public Optional<T> findAny() {
        return st().findAny();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return ls().toArray(a);
    }

    @Override
    public <T1> T1[] toArray(IntFunction<T1[]> generator) {
        return ls().toArray(generator);
    }

    @Override
    public boolean add(T t) {
        throw new UnsupportedOperationException();//TODO
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();//TODO
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return ls().containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException();//TODO
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();//TODO
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();//TODO
    }

    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        throw new UnsupportedOperationException();//TODO
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return ls().retainAll(c);
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {
        throw new UnsupportedOperationException();//TODO
    }

    @Override
    public void sort(Comparator<? super T> c) {
        throw new UnsupportedOperationException();//TODO
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();//TODO
    }

    @Override
    public T get(int index) {
        return ls().get(index);
    }

    @Override
    public T set(int index, T element) {
        throw new UnsupportedOperationException();//TODO
    }

    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException();//TODO
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException();//TODO
    }

    @Override
    public int indexOf(Object o) {
        return ls().indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return ls().lastIndexOf(o);
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException();//TODO
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException();//TODO
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return new Listream<>(ls().subList(fromIndex, toIndex));
    }

    @Override
    public Spliterator<T> spliterator() {
        throw new UnsupportedOperationException();//TODO
    }

    @Override
    public Stream<T> stream() {
        return this;
    }

    @Override
    public Stream<T> parallelStream() {
        throw new UnsupportedOperationException();//TODO
    }

    @Override
    public String toString(){
        return ls().toString();
    }
}
