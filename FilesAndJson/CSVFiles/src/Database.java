public class Database {
    private String[] colNames;
    private int numRows;
    private String[][] data;

    public String[] getColNames() {
        return colNames;
    }

    public void setColNames(String[] colNames) {
        this.colNames = colNames;
    }

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public String[][] getData() {
        return data;
    }

    public void setData(String[][] data) {
        this.data = data;
    }

    public Database(String contents) {
//           Alternative code
//        colNames = (contents.substring(0, contents.indexOf("\n"))).split(",");
//        contents = contents.substring(contents.indexOf("\n"),contents.lastIndexOf("\n"));
//        contents = contents.replaceFirst("\n", "");
//        numRows = contents.split("\r?\n").length;
//        data = new String [contents.replaceAll ("[^" + "\n" + "]", "").length () + 1][];
//        int count = 0;
//        for (String line : contents.split("["+"\n"+"]"))
//            data[count++] = line.split(",");

        String[] rows = contents.split("\r?\n");
        colNames = rows[0].split(",");
        numRows = rows.length - 1;
        data = new String[numRows][colNames.length];
        for (int i = 0; i < numRows; i++)
            data[i] = rows[i+1].split(",");

    }

    public String getValue(String columnName,int row){
        for (int col = 0; col < colNames.length; col++)
            if (colNames[col].equals(columnName))
                return data[row][col];

        return "";
    }

}


