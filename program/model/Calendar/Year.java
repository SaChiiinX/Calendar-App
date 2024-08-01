package program.model.Calendar;

public class Year {
    int year;
    // numerical representation for year
    public Month[] months = new Month[12];
    // Array containing all 12 months
    public Year (boolean leap, int year) {
        // Creates fixed array of 12 months for each year
        this.year = year;
        months[0] = Month.JANUARY;
        months[1] = Month.FEBRUARY;
        months[2] = Month.MARCH;
        months[3] = Month.APRIL;
        months[4] = Month.MAY;
        months[5] = Month.JUNE;
        months[6] = Month.JULY;
        months[7] = Month.AUGUST;
        months[8] = Month.SEPTEMBER;
        months[9] = Month.OCTOBER;
        months[10] = Month.NOVEMBER;
        months[11] = Month.DECEMBER;
        for (Month month : months) month.fill(leap, year);
    }

    public String toString () {
        // Prints string view of the entire year, as a 3 x 4 rectangular setup for the 12 months
        StringBuilder resBuilder = new StringBuilder();
        String spaceUnit = "    ";
        String[] months = new String[12];
        String[][] spacing = new String[12][];
        int lineCount = 0;
        for (int i = 0; i < 12; i++) {
            months[i] = this.months[i].toString();
            spacing[i] = months[i].split("\n");
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 4; k++) {
                    resBuilder.append(spacing[k + lineCount][j]).append(spaceUnit);
                }
                resBuilder.append("\n");
            }
            resBuilder.append("\n");
            lineCount += 4;
        }
        return resBuilder.toString();
    }
}
