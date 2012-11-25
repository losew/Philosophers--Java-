import logic.Man;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
public class Drawer extends Canvas
{
    private Man[] mm;
    public Drawer(Man[] men)
{
mm = men;
}
    private void drawForks(Graphics g)
    {
        int xCenter =  150;
        int yCenter =  125;
        int radix = 75;
        for (int i=0; i<5; i++)
        {
            double xShift  = radix * Math.cos(i*Math.PI/2.5);
            double yShift  = radix * Math.sin(i*Math.PI/2.5);
            double xShift1 = radix * Math.cos((i+0.3)*Math.PI/2.5);
            double yShift1 = radix * Math.sin((i+0.3)*Math.PI/2.5);
            double xShift2 = radix * Math.cos((i-0.3)*Math.PI/2.5);
            double yShift2 = radix * Math.sin((i-0.3)*Math.PI/2.5);
            double xShifta = radix * Math.cos((i-0.5)*Math.PI/2.5);
            double yShifta = radix * Math.sin((i-0.5)*Math.PI/2.5);
            double xShiftb = radix * Math.cos((i+0.5)*Math.PI/2.5);
            double yShiftb = radix * Math.sin((i+0.5)*Math.PI/2.5);
            if (Man.chkFork(i) == 0)
            {
                g.drawLine((int) (xCenter + xShift*0.3),
                           (int) (yCenter + yShift*0.3),
                           (int) (xCenter + xShift*0.8),
Файл «Drawer.java»
Используется для рисования
); }
(int) (yCenter + yShift*0.8)
else if (Man.chkFork(i) == (i+1))
{
    g.drawLine((int) (xCenter + xShift1*0.3),
               (int) (yCenter + yShift1*0.3),
               (int) (xCenter + xShift1*0.8),
); }
else {
); }
} }
(int) (yCenter + yShift1*0.8),
(int) (xCenter + xShiftb),
(int) (yCenter + yShiftb)
           (int) (yCenter + yShift1*0.8)
);
g.drawLine((int) (xCenter + xShift1*0.8),
g.drawLine((int) (xCenter + xShift2*0.3),
           (int) (yCenter + yShift2*0.3),
           (int) (xCenter + xShift2*0.8),
           (int) (yCenter + yShift2*0.8)
);
g.drawLine((int) (xCenter + xShift2*0.8),
(int) (yCenter + yShift2*0.8),
(int) (xCenter + xShifta),
(int) (yCenter + yShifta)
private void drawPeople(Graphics g)
{
    int xCenter =  150;
    int yCenter =  125;
    int radix = 75;
    Image walk = new ImageIcon("img\\walk.gif").getImage();
    int walkh = walk.getHeight(this)/2;
    int walkw = walk.getWidth(this)/2;
    Image stand = new ImageIcon("img\\stand.gif").getImage();
    int standh = stand.getHeight(this)/2;
    int standw = stand.getWidth(this)/2;
    Image sit = new ImageIcon("img\\sit.gif").getImage();
    int sith = sit.getHeight(this)/2;
    int sitw = sit.getWidth(this)/2;
    Image eat = new ImageIcon("img\\eat.gif").getImage();
    int eath = eat.getHeight(this)/2;
    int eatw = eat.getWidth(this)/2;
    for (int i=0; i<5; i++)
    {
        double xShift  = radix * Math.cos((i+0.5)*Math.PI/2.5);
        double yShift  = radix * Math.sin((i+0.5)*Math.PI/2.5);
        if (mm == null)
continue;
        switch (mm[i].getState())
        {
        case 0:
            g.drawImage(walk, 400 + i*3*walkw, 200, this);
        break;
        case 1:
            g.drawImage(stand,
                        (int) (xCenter + xShift*1.3 - standw),
                        (int) (yCenter + yShift*1.3 - standh),
                        this);
break;
        case 2:
            g.drawImage(sit,
break;
} }
}
(int) (yCenter + yShift*1.3 - eath),
this);
break;
case 3:
case 4:
(int) (xCenter + xShift*1.3 - sitw),
(int) (yCenter + yShift*1.3 - sith),
this);
g.drawImage(eat,
            (int) (xCenter + xShift*1.3 - eatw),
    private void drawDoor(Graphics g)
    {
        g.drawLine(300, 0, 300, 75);
        g.drawLine(300, 191, 300, 266);
        switch(logic.Servant.getState())
        {
        case 0:
            g.drawLine(300, 75, 329, 25);
            g.drawLine(300, 191, 329, 241);
            break;
        case 1:
            g.drawLine(300, 75, 300, 191);
            break;
} }
    // Рисуем картинку
    public void paint(Graphics g2)
    {
        BufferedImage img = new BufferedImage(this.getWidth(), this.getHeight(),
BufferedImage.TYPE_3BYTE_BGR);
        Graphics g = img.getGraphics();
        int width = this.getWidth();
        int height = this.getHeight();
        g.setColor(this.getBackground());
        g.fillRect(0, 0, width, height);
        g.setColor(Color.gray);
        g.drawString("Width: " + width + " Height: " + height, width-125, height
- 5);
        g.setColor(Color.black);
        int xCenter =  150;
        int yCenter =  125;
        int radix = 75;
        g.drawOval(xCenter-radix, yCenter-radix, radix*2, radix*2);
        // Drawing forks and people
        drawForks(g);
        drawPeople(g);
        drawDoor(g);
        g2.drawImage(img, 0, 0, this);
    }
}