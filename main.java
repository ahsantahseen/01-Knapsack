import java.util.Scanner;

class D01Knapsack {

    public static int[][] knapsack(int knapsackWeight, int WeightOfObjects[], int ValueOfObjects[],
            int numberOfObjects) {
        int Table[][] = new int[numberOfObjects + 1][knapsackWeight + 1];
        int i, j;
        for (i = 0; i <= numberOfObjects; i++) {
            for (j = 0; j <= knapsackWeight; j++) {

                if (i == 0 || j == 0) {
                    Table[i][j] = 0;
                } else if (WeightOfObjects[i - 1] <= j) {
                    Table[i][j] = Math.max(ValueOfObjects[i - 1] + Table[i - 1][j - WeightOfObjects[i - 1]],
                            Table[i - 1][j]);

                } else {

                    Table[i][j] = Table[i - 1][j];

                }

            }

        }
        return Table;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER NUMBER OF ELEMENTS:");
        int numberOfelements = sc.nextInt();
        System.out.println("ENTER MAX WEIGHT OF KNAPSACK:");
        int knapsackWeight = sc.nextInt();
        int Weight[] = new int[numberOfelements];
        int Value[] = new int[numberOfelements];
        for (int i = 0; i < numberOfelements; i++) {
            System.out.println("ENTER ELEMENT WEIGHT:");
            Weight[i] = sc.nextInt();
            System.out.println("ENTER ELEMENT VALUE");
            Value[i] = sc.nextInt();
        }
        int n = Value.length;
        int Table[][] = knapsack(knapsackWeight, Weight, Value, n);
        System.out.println("NUMBER OF ELEMENTS:" + numberOfelements);
        System.out.println("MAX WEIGHT:" + knapsackWeight);
        System.out.println("ELEMENTS(weight,benifit)");
        for (int i = 0; i < numberOfelements; i++) {
            System.out.println(Weight[i] + "," + Value[i]);
        }
        System.out.println("KNAPSACK TABLE");
        for (int i = 0; i < Table.length; i++) {
            for (int j = 0; j < Table[i].length; j++) {
                System.out.print(Table[i][j] + "");
            }
            System.out.println();
        }
        System.out.println("Maximum Profit: " + Table[n][knapsackWeight]);
        System.out.println("ELEMENTS USED FOR MAXIMUM PROFIT (Weight,Benifit):");

        for (int i = Table.length - 1; i > 0; i--) {
            if (Table[i][knapsackWeight] != Table[i - 1][knapsackWeight]) {
                System.out.println(Weight[i - 1] + "," + Value[i - 1]);
            }

        }
    }
}
