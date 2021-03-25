package sample;
import java.util.*;

public class Game {
    private Blocks[][] blocksMatrix;
    public static final int rows = 6;
    public static final int cols = 6;

    Game()
    {
        blocksMatrix = new Blocks[rows][cols];

        for(int i=0; i < rows; i++)
        {
            for(int j=0; j < cols; j++)
            {
                blocksMatrix[i][j] = new Blocks();
            }
        }

        this.generateMatrix();
    }

    private void generateMatrix() {
        Random random = new Random();
        int[] generated = new int[18];
        Arrays.fill(generated, 0);
        int imageNumber;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                do {
                    imageNumber = random.nextInt(18);
                } while (generated[imageNumber] == 2);

                generated[imageNumber]++;
                String path = "img/Image" + (imageNumber + 1) + ".png";
                blocksMatrix[i][j].setPath(path);
            }
        }
    }

    public void printMatrix()
    {
        for(int i=0; i < rows; i++)
        {
            for(int j=0; j < cols; j++)
            {
                System.out.println(blocksMatrix[i][j].getPath());
            }
        }
    }

    public Blocks getElement(int i, int j)
    {
        return this.blocksMatrix[i][j];
    }
}
