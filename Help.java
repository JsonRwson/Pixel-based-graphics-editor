import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Help {

    private JFrame frame;
    private JTabbedPane helpMain;
    private JEditorPane toolsHelp, layersHelp, coloursHelp, savingAndOpeningHelp, exportingAndAnimationHelp;
    private JScrollPane toolsScroll, layersScroll, coloursScroll, saveScroll, exportScroll;

    public Help()
    {
        frame = new JFrame();
        frame.setTitle("Help and Information");
        frame.setSize(600,500);
        ImageIcon windowIcon = new ImageIcon("Icons/brush-outline.png");
        frame.setIconImage(windowIcon.getImage());
        frame.setResizable(false);

        toolsScroll = new JScrollPane();
        layersScroll = new JScrollPane();
        coloursScroll = new JScrollPane();
        saveScroll = new JScrollPane();
        exportScroll = new JScrollPane();

        toolsHelp = new JEditorPane();   
        layersHelp = new JEditorPane();
        coloursHelp = new JEditorPane();
        savingAndOpeningHelp = new JEditorPane();
        exportingAndAnimationHelp = new JEditorPane();

        toolsScroll.setViewportView(toolsHelp);
        toolsScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        toolsScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        layersScroll.setViewportView(layersHelp);
        layersScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        layersScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        coloursScroll.setViewportView(coloursHelp);
        coloursScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        coloursScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        saveScroll.setViewportView(savingAndOpeningHelp);
        saveScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        saveScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        exportScroll.setViewportView(exportingAndAnimationHelp);
        exportScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        exportScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        toolsHelp.setEditable(false);
        layersHelp.setEditable(false);
        coloursHelp.setEditable(false);
        savingAndOpeningHelp.setEditable(false);
        exportingAndAnimationHelp.setEditable(false);

        toolsHelp.setContentType("text/html");
        toolsHelp.setText(readHelpFile("./Help/tools.html"));

        layersHelp.setContentType("text/html");
        layersHelp.setText(readHelpFile("./Help/layers.html"));

        coloursHelp.setContentType("text/html");
        coloursHelp.setText(readHelpFile("./Help/colours.html"));

        savingAndOpeningHelp.setContentType("text/html");
        savingAndOpeningHelp.setText(readHelpFile("./Help/save.html"));

        exportingAndAnimationHelp.setContentType("text/html");
        exportingAndAnimationHelp.setText(readHelpFile("./Help/export.html"));

        helpMain = new JTabbedPane();
        helpMain.addTab("Tools", toolsScroll);
        helpMain.addTab("Layers", layersHelp);
        helpMain.addTab("Colours", coloursHelp);
        helpMain.addTab("Saving & Opening", savingAndOpeningHelp);
        helpMain.addTab("Exporting & Animation", exportingAndAnimationHelp);

        frame.setContentPane(helpMain);
        frame.setVisible(true);
    }

    public String readHelpFile(String filepath)
    {
        String data = "";
        try
        {
            BufferedReader file = new BufferedReader(new FileReader(filepath));
            StringBuilder builder = new StringBuilder();
            String fileLine = file.readLine();

            while(fileLine != null)
            {
                builder.append(fileLine);
                builder.append(System.lineSeparator());
                fileLine = file.readLine();
            }

            data = builder.toString();
            file.close();
            return data;
        }
        catch(FileNotFoundException a)
        {
            data = "Help files not found! please reinstall!\nhttps://scc-source.lancs.ac.uk/scc210-2022-23/scc210-2223-grp-64";
        }
        catch(IOException b)
        {
            data = "Help files not found! please reinstall!\nhttps://scc-source.lancs.ac.uk/scc210-2022-23/scc210-2223-grp-64";
        }
        return data;
    }
}
