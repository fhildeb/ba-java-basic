package Datum;

import java.io.*;

/**
 *  Einfache Klasse zur <B>Tastatur-Eingabe</B> von <B>Zeichenketten</B> und
 *  <B>Zahlenwerten</B> . <BR>
 *  Beim Einlesen von Zahlenwerten werden Format-Ausnahmen ausgelöst, wenn
 *  keine gültige Zahl eingegeben wird.
 *
 */

public class Keyboard
{
    /**
     *  Zum Einlesen der Tastatur-Eingabe wird ein <TT>BufferedReader</TT>
     *  vom Standard-Eingabe-Kanal verwendet.
     */
    private static BufferedReader in = new BufferedReader(
            new InputStreamReader(System.in));


    /**
     *  Lesen einer Zeichenkette von der Tastatur. Eine hier nur theoretisch
     *  mögliche <TT>IOException</TT> wird ohne Reaktion abgefangen.
     *
     * @return    eingegebene Zeichenkette
     */
    public static String readString()
    {
        String s = "";
        try
        {
            s = in.readLine();
        }
        catch (IOException e)
        {
            /*
             * keine Reaktion
             */
        }
        ;
        return s;
    }


    /**
     *  Lesen eines <TT>int</TT> -Werts von der Tastatur.
     *
     * @return                            eingegebener <TT>int</TT> -Wert
     * @exception  NumberFormatException  falls kein gültiger <TT>int</TT>
     *      -Wert eingegeben wird
     */
    public static int readint() throws NumberFormatException
    {
        String s = readString();
        int n = Integer.parseInt(s);
        return n;
    }


    /**
     *  Lesen eines <TT>long</TT> -Werts von der Tastatur.
     *
     * @return                            eingegebener <TT>long</TT> -Wert
     * @exception  NumberFormatException  falls kein gültiger <TT>long</TT>
     *      -Wert eingegeben wird
     */
    public static long readlong() throws NumberFormatException
    {
        String s = readString();
        long n = Long.parseLong(s);
        return n;
    }

    /**
     *  Lesen eines <TT>float</TT> -Werts von der Tastatur.
     *
     * @return                            eingegebener <TT>float</TT> -Wert
     * @exception  NumberFormatException  falls kein gültiger <TT>float
     *      </TT>-Wert eingegeben wird
     */
    public static float readfloat() throws NumberFormatException
    {
        String s = readString();
        float n = Float.valueOf(s).floatValue();
        return n;
    }


    /**
     *  Lesen eines <TT>double</TT> -Werts von der Tastatur.
     *
     * @return                            eingegebener <TT>double</TT> -Wert
     * @exception  NumberFormatException  falls kein gültiger <TT>double
     *      </TT>-Wert eingegeben wird
     */
    public static double readdouble() throws NumberFormatException
    {
        String s = readString();
        double n = Double.valueOf(s).doubleValue();
        return n;
    }
}
