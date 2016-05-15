package util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * La classe SpriteSheetLoader, scompatta e organizza immagini accorpate in griglie
 * @author roberto
 */

public class SpriteSheetLoader {

    private BufferedImage spriteSheet;
    private int width;
    private int height;
    private int rows;
    private int columns;
    private BufferedImage[] sprites;

    /**
     * @SpriteSheetLoader scompata un'immagine in in sotto immagini
     * @param rows Righe della griglia
     * @param colums Colonne della griglia
     * @param location Indirizzo della locazione dell'immagine
     * @throws IOException Nel caso in cui si è impossibilitati a leggere l'immagine
     */

    public SpriteSheetLoader(int rows, int colums, String location) throws IOException, IllegalArgumentException {
        if (rows <=0) {
            throw new IllegalArgumentException("Numero di colonne della griglia non valida");
        }
        if (colums<=0) {
            throw new IllegalArgumentException("Numero di righe della griglia non valida");
        }

        this.rows = rows;
        this.columns = colums;
        this.sprites = new BufferedImage[this.rows * this.columns];
        this.spriteSheet = ImageIO.read(getClass().getResource(location));
        this.height = (int)(this.spriteSheet.getTileHeight() / this.rows);
        this.width = (int)(this.spriteSheet.getTileWidth() / this.columns);

        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.columns; j++) {
                this.sprites[(i * this.columns) + j] = this.spriteSheet.getSubimage(j * this.width, i * this.height, this.width, this.height);
            }
        }

    }

    /**
     * Preleva una delle sotto-immagini scompattate dalla griglia
     * @param pi Locazione del singolo elemento della griglia di immagini (pi = righe * colonne)
     * @return Restituisce un singolo elemento della griglia di immagini
     */
    public BufferedImage paint(int pi) throws IllegalArgumentException {
        if (pi < 0 || pi > (this.rows * this.columns))
            throw new IllegalArgumentException("la sotto immagine a cui cerchi di accedere non esiste: n" + pi);
        return this.sprites[pi];
    }
    /**
     * @getWidth Larghezza della sotto immagine
     * @getHeight Altezza della sotto immagine
     */
    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

}