
import PhilConst;
import logic.Man.*;
import logic.PhilException.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Main extends JPanel{
    // public static members
public static final String header = "Обедающие философы"; public static final String drawAreaHeader = "Картинка"; public static final String controlsHeader = "Управление"; public static final String loggerHeader = "Логи";
    // private members
    private boolean[] philStates = {false, false, false, false, false};
    private boolean servant = true;
    private JPanel drawArea = null;
    private Drawer drawer = null;
    private JPanel controls = null;
    private JPanel logger   = null;
    private JButton next = null;
    private JButton reset = null;
    private JCheckBox[] philLogs;
    private JCheckBox srvButton = null;
    private JTextPane logPane = null;
    private PhilStyleDocument log = null;
    private JTable table = null;
    public Man[] men;
    public Main()
    {
        super(new BorderLayout(), true);
        initLogic();
        logger = createLogger();
        Man.prn = log;
        controls = createControls();
        PhilException.prn = log;
        this.add(controls, BorderLayout.EAST);
        this.add(logger, BorderLayout.WEST);
        drawArea = createDrawArea();
        this.add(drawArea, BorderLayout.NORTH);
        drawArea.repaint();
}
    private JPanel createDrawArea()
    {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(drawAreaHeader));
        drawer = new Drawer(men);
	panel.add(drawer, BorderLayout.CENTER);
    panel.setPreferredSize(new Dimension(800, 300));
    return panel;
}
private JPanel createControls()
{
JPanel panel = new JPanel(new BorderLayout(25, 35));
panel.setBorder(BorderFactory.createTitledBorder(controlsHeader));
table = new JTable(new MyTableModel());
table.getColumnModel().getColumn(0).setPreferredWidth(75);
table.getColumnModel().getColumn(1).setPreferredWidth(25);
table.getColumnModel().getColumn(2).setPreferredWidth(100);
JScrollPane scroller = new JScrollPane(table);
scroller.setPreferredSize(new Dimension(245, 100));
panel.add(scroller, BorderLayout.NORTH);
next = new JButton("Далее"); next.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e)
    {
        for (int i=0; i<5; i++)
men[i].setH(((Boolean)table.getValueAt(i,1)).booleanValue());
                for (int i=0; i<5; i++)
                {
                    if (men[i].getH())
                        continue;
                    men[i].proceed();
table.setValueAt(logic.PhilConst.stateMap[men[i].getState()],i, 2);
                }
                for (int i=0; i<5; i++)
                {
                    if (!men[i].getH())
                        continue;
                    men[i].proceed();
table.setValueAt(logic.PhilConst.stateMap[men[i].getState()],i, 2);
                }
                drawer.repaint();
            }
        });
        next.setSize(new Dimension(100, 25));
        panel.add(next, BorderLayout.CENTER);
        JLabel label = new JLabel("By Sergey Pak");
        label.setPreferredSize(new Dimension(90, 25));
        label.setAlignmentX(0.5f);
        label.setFont(new Font("Courier", Font.ITALIC, 10));
        label.setForeground(new Color(104, 104, 104));
        JPanel pane = new JPanel(new BorderLayout());
        pane.add(label, BorderLayout.EAST);
        panel.add(pane, BorderLayout.SOUTH);
        panel.setPreferredSize(new Dimension(300, 250));
        return panel;
    }
private JPanel createLogger()
{
// Размер панели: 400х250
JPanel panel = new JPanel(new BorderLayout()); panel.setBorder(BorderFactory.createTitledBorder(loggerHeader)); log = new PhilStyleDocument();
logPane = new JTextPane(log);
logPane.setEditable(false);
JScrollPane scroller = new JScrollPane(logPane);
    panel.add(scroller, BorderLayout.CENTER);
    panel.add(createLogBar(), BorderLayout.SOUTH);
    panel.setPreferredSize(new Dimension(550, 250));
    return panel;
}
private JToolBar createLogBar()
{
    JToolBar bar = new JToolBar("Sergey");
    for(int i=0; i<5; i++)
    {
        final int a = i;
        philLogs[i] = new JCheckBox(PhilConst.names[i]);
        philLogs[i].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                philStates[a] = philLogs[a].isSelected();
                men[a].setLogged(philStates[a]);
            }
});
        bar.add(philLogs[i]);
    }
    bar.setFloatable(false);
return bar; }
private void initLogic()
{
    men = new Man[5];
    for (int i=0; i< 5;i++)
    {
        men[i] = new Man(i, PhilConst.names[i], false, philStates[i]);
    }
}
public static void main(String[] args)
{
    JFrame frame = new JFrame(header);
    frame.addWindowListener(new WindowAdapter()
    {
        public void windowClosing(WindowEvent e)
        {
exit(0); }
    });
    Main panel = new Main();
    frame.getContentPane().add(panel, BorderLayout.CENTER);
    frame.pack();
    frame.setResizable(false);
    frame.setLocation(100, 100);
    frame.show();
}
private static void exit(int errorCode)
    {
        System.exit(errorCode);
    }
}