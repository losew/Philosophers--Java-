package logic;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
/*
Файл используется для вывода информации об ошибках (вилка занята, нельзя войти и т.п.) в панель «Логи» визуализатора
*/
public class PhilException extends Exception
{
    public static Document prn = null;
    public PhilException(String str)
    {
        super(str);
        MutableAttributeSet set1 = new SimpleAttributeSet();
        StyleConstants.setForeground(set1, Color.red);
        StyleConstants.setFontFamily(set1, "Courier New");
        try
        {
            prn.insertString(prn.getLength(),
                    str,
set1);
        }
        catch(Exception e)
        {
            e.printStackTrace();
} }
}