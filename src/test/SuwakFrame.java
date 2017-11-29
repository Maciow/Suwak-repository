package test;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Dictionary;
import java.util.Hashtable;

public class SuwakFrame extends JFrame{
    private JPanel sliderPanel;
    private JTextField textField;
    private ChangeListener listener;

    public SuwakFrame(){
        sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridBagLayout());

        listener = e -> {
          JSlider source = (JSlider) e.getSource();
          textField.setText(""+source.getValue());
        };

        //zwykły
        JSlider slider = new JSlider();
        addSlider(slider,"Zwykły");

        //z przedziałką
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider,"Podziałka");

        //z dosunięcię
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setSnapToTicks(true);
        addSlider(slider,"Dosuwany");

        //bez prowadnicy
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTrack(false);
        addSlider(slider,"Bez prowadnicy");

        //odwrócony
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setInverted(true);
        addSlider(slider,"Odwrócony");

        //etykiety
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider,"Etykiety");

        //etykiety literowe
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);

        Dictionary<Integer,Component> labelTabel = new Hashtable<>();
        labelTabel.put(0,new JLabel("A"));
        labelTabel.put(20,new JLabel("B"));
        labelTabel.put(40,new JLabel("C"));
        labelTabel.put(60,new JLabel("D"));
        labelTabel.put(80,new JLabel("E"));
        labelTabel.put(100,new JLabel("F"));

        slider.setLabelTable(labelTabel);
        addSlider(slider,"Niestandardowe etykiety");

        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(20);

        labelTabel = new Hashtable<>();

        //dodawanie obrazów kart

        labelTabel.put(0, new JLabel(new ImageIcon("blue.png")));
        labelTabel.put(20, new JLabel(new ImageIcon("blue2.png")));
        labelTabel.put(40, new JLabel(new ImageIcon("red.png")));
        labelTabel.put(60, new JLabel(new ImageIcon("red2.png")));
        labelTabel.put(80, new JLabel(new ImageIcon("yellow.png")));
        labelTabel.put(100, new JLabel(new ImageIcon("yellow2.png")));

        slider.setLabelTable(labelTabel);
        addSlider(slider, "Ikony");

        //pole tekstowe wyświetlające wartości sliderów
        textField = new JTextField();
        add(sliderPanel,BorderLayout.CENTER);
        add(textField,BorderLayout.SOUTH);
        pack();
    }
    public void addSlider(JSlider slider,String description){
        slider.addChangeListener(listener);
        JPanel panel = new JPanel();
        panel.add(slider);
        panel.add(new JLabel(description));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = sliderPanel.getComponentCount();
        gbc.anchor = GridBagConstraints.WEST;
        sliderPanel.add(panel,gbc);
    }
}
