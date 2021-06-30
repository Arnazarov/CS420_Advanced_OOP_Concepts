public class BingoChip<T, N> {
    private T column;
    private N number;

    public BingoChip(T col, N num) {
        column = col;
        number = num;
    }
    @Override
    public String toString(){
        return("Chip" + column.toString() + "-" + number.toString());
    }
}

