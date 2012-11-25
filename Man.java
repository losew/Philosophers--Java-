package logic;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.MutableAttributeSet;
import java.awt.Color;
import java.text.DateFormat;
public class Man
{
private static final String philMessage = "Исключение в Философе #";
    private static MutableAttributeSet set1 = null;
    private static MutableAttributeSet set2 = null;
    private static MutableAttributeSet set3 = null;
    private static MutableAttributeSet set = null;
    private static int[] forks = new int[5];
    private int state = 0;
    private int num = 0;
    private int time = 0;
    private boolean x0 = false;
    private boolean isLogged = true;
    private boolean messagePrinted;
    private String name = null;
    private String philStateMessage = null;
    public static Document prn = null;
    protected Man()
{
Файл «Man.java»
Класс философ
// Константы для вывода цветного текста в поле
set1 = new SimpleAttributeSet();
StyleConstants.setForeground(set1, Color.black);
StyleConstants.setFontFamily(set1, "Courier New");
set2 = new SimpleAttributeSet();
StyleConstants.setForeground(set2, Color.blue);
StyleConstants.setFontFamily(set2, "Courier New");
set3 = new SimpleAttributeSet();
StyleConstants.setForeground(set3, Color.green);
StyleConstants.setFontFamily(set3, "Courier New");
set = new SimpleAttributeSet();
StyleConstants.setForeground(set, Color.darkGray);
    StyleConstants.setFontFamily(set, "Courier New");
    new Servant();
}
// Основной конструктор
public Man(int n, String str, boolean isH, boolean isL)
{
    this();
    setNum(n);
    this.philStateMessage = PhilConst.names[n] + ":";
    this.state = 0;
    this.isLogged = isL;
    setName(str);
    setX0(isH);
}
public int getNum()     {return num;}
public int getState()   {return state;}
public String getName() {return name;}
public boolean getX0()   {return x0;}
public int getTime()    {return time;}
public boolean isLogged(){return isLogged;}
public void setLogged(boolean newLogState) {isLogged = newLogState;}
public void setNum(int n)       {num = n;}
public void setName(String str) {name = str;}
public void setX0(boolean isH)
public void setTime(int t)
// Автомат А0
public void proceed()
{
    messagePrinted = false;
    try
    {
        switch(state)
 {x0 = isH;}
{time = t;}
{
case 0: // Гуляет
        if (x0 && x1())
        {
            z0();
            state = 1;
            break;
        }
        if (x0 && !x1())
{
}
if (!x0) {
state = 0;
break; }
break;
case 1:
// Находится в столовой
createPhilException(3);
state = 0;
break;
// Выводим логи
if (x0 && x2())
{
z1();
state = 2;
break; }
    if (x0 && !x2())
{
createPhilException(1); // Выводим логи state = 1;
break;
}
if (!x0) {
        z5();
        state = 0;
        break;
} break;
case 2:
    if (x0 && x3())
{
z2();
state = 3;
break; }
    if (x0 && !x3())
{
}
if (!x0) {
        z4();
        state = 1;
        break;
} break;
case 3: // Ест if (x0)
{
break; }
if (!x0) {
        z3();
        state = 2;
        break;
} break;
default: {
// Ошибка
// Сидит за столом (вилка в левой руке)
createPhilException(2);
state = 2;
break;
// Выводим логи
state = 3;
                throw createPhilException(0);
            }
}
        printStateMessage();
    }
    catch(PhilException e)
    {
    }
}
/*
Входные воздействия автомата А0
*/
// Сыт философ или голоден (x0)
private boolean x1()
{
    if (!messagePrinted)
        locprn(4);
    messagePrinted = true;
    return (Servant.getState() == 0);
}
// Пытаемся открыть дверь (x1)
private boolean x2()
{
    if (!messagePrinted)
        locprn(0);
    messagePrinted = true;
    return (forks[num] == 0);
}
// Проверяем свободна ли левая вилка (x2)
private boolean x3()
{
    if (!messagePrinted)
        locprn(2);
    messagePrinted = true;
    return (forks[(num+1)%5] != 0);
}
// Проверяем свободна ли правая вилка (x3)
public static int chkFork(int num)
{
    return forks[num];
}
// Философ пытается войти
private void z0()
{
    Servant.proceed(true);
locprn(5); }
// Пытаемся взять левую вилку
private void z1()
{
forks[num] = num+1; // Это вилку взял данный философ locprn(1);
}
// Пытаемся взять правую вилку
private void z2()
{
forks[(num+1)%5] = num+1; // Это вилку взял данный философ
locprn(3); }
// Положили правую вилку обратно
private void z3()
{
    forks[(num+1)%5] = 0;
locprn(7); }
// Положили левую вилку обратно
private void z4()
{
    forks[num] = 0;
locprn(6); }
// Выходим из столовой
private void z5()
{
    Servant.proceed(false);
locprn(8); }
private PhilException createPhilException(int number)
{
return new PhilException("Исключение: " + name + ": " + PhilConst.exceptionMap[number] + '\n');
}
private void printStateMessage()
{
    String[] map = PhilConst.stateMessageMap;
    if (!isLogged)
return; try
    {
        switch (state)
{
case 0:
if (x0)
                stateprn(map[0], set1);
            else
                stateprn(map[1], set1);
            break;
        case 1:
            if (x0)
                stateprn(map[2], set1);
            else
                stateprn(map[3], set1);
            break;
        case 2:
            if (x0)
                stateprn(map[4], set2);
            else
                stateprn(map[5], set2);
            break;
        case 3:
            if (x0)
                stateprn(map[6], set3);
            else
                stateprn(map[7], set3);
            break;
} }
    catch (Exception e)
    {
        e.printStackTrace();
    }
}
public static void prn(String str)
{
try
        {
            String data =  DateFormat.getInstance().format(new
java.util.Date());
set);
}
prn.insertString(prn.getLength(), new String(data +" "+ str + "\n"),
        catch(Exception e)
        {
            e.printStackTrace();
        }
}
    public static void prn(String str, MutableAttributeSet set)
    {
try {
            String data =  DateFormat.getInstance().format(new
java.util.Date());
set);
}
prn.insertString(prn.getLength(), new String(data +" "+ str + "\n"),
        catch(Exception e)
        {
            e.printStackTrace();
        }
}
    public void locprn(int n)
    {
        if (isLogged)
            prn(name + " " + PhilConst.messageMap[n]);
}
    public void stateprn(String str, MutableAttributeSet set)
    {
try {
            prn.insertString(prn.getLength(), name + ": " + str + "\n", set);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
} }