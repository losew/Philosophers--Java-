package logic;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
public class Servant
{
    private static int state = 0;
    private static int x0=0;
    private static MutableAttributeSet set = null;
public Servant()
{
    set = new SimpleAttributeSet();
    StyleConstants.setForeground(set, new Color(255, 0, 255));
    StyleConstants.setFontFamily(set, "Courier New");
    StyleConstants.setBold(set, false);
    StyleConstants.setBackground(set, Color.yellow);
}
public static int getState()
{
    return state;
}
public static int getQuanity()
{
return x0;
}
// Автомат А1
public static void proceed(boolean in)
{
switch(state)
{
case 0:
    if (in && (x0 < 3))
{
z0();
state = 0;
break; }
    if (in && (x0 == 3))
    {
        z0();
        state = 1;
        break;
}
// Еще есть свободные места
// Свободных мест больше не будет
// Философ хочет выйти
// Философ хочет выйти
// Впустить философа
if (!in)
{
z1();
state = 0;
break; }
case 1:
    if (!in)
{
z1();
state = 0;
break; }
} }
private static void z0()
{
x0++;
}
Man.prn("Слуга: Философ впущен", set);
if (x0 == 4)
{
Man.prn("Слуга: больше никого не пущу", set); }
private static void z1() // Выпустить философа
{
x0--;
        Man.prn("Слуга: Философ выпущен", set);
        if (x0 == 3)
{
Man.prn("Слуга: сюда можно входить", set);
} }
}