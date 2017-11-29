import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Ramka zawierająca kilka suwaków oraz pole tekstowe pokazujące wartości ustawione za ich pomocą
 */

public class SliderFrame extends JFrame {
    private JPanel sliderPanel;
    private JTextField textField;
    private ChangeListener listener;

    public SliderFrame(){
        sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridBagLayout());

        //Wspólny nasłuchiwacz wszystkich suwaków
        listener = e -> {
            //Aktualizacja pola tekstowego w odpowiedzi na zmianę wartości suwaka
            JSlider source = (JSlider) e.getSource();
            textField.setText(""+source.getValue());
        };

        //Zwykły suwak
        JSlider slider = new JSlider();
        addSlider(slider,"Zwykły");

        //Suwak z przedziałką
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setSnapToTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider,"Podziałka");

        //Suwak bez prowadnicy
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTrack(false);
        addSlider(slider,"Bez prowadnicy");

        //Suwak o odwróconym działaniu
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setInverted(true);
        addSlider(slider,"Odwrócony");

        //Suwak z etykietami liczbowymi
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider,"Etykiety");

        //suwak z etykietami literowymi
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);

        Dictionary<Integer,Component> labelTable = new Hashtable<>();
        labelTable.put(0,new JLabel("A"));
        labelTable.put(20,new JLabel("B"));
        labelTable.put(40,new JLabel("C"));
        labelTable.put(60,new JLabel("D"));
        labelTable.put(80,new JLabel("E"));
        labelTable.put(100,new JLabel("F"));

        slider.setLabelTable(labelTable);
        addSlider(slider,"Niestandardowe etykiety");

        //suwak z etykietami ikonowymi
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(20);

        //Dodawanie pola tekstowego które wyświetla wartość ustawioną na suwaku

        textField = new JTextField();
        add(sliderPanel,BorderLayout.CENTER);
        add(textField, BorderLayout.SOUTH);
        pack();
    }
    /**
     * Dodaje suwak do panelu suwaków i dowiązuje nasłuchiwacz
     * @param s suwak
     * @param description opis suwaka
     */
    public void addSlider(JSlider s, String description){
        s.addChangeListener(listener);
        JPanel panel = new JPanel();
        panel.add(s);
        panel.add(new JLabel(description));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = sliderPanel.getComponentCount();
        gbc.anchor = GridBagConstraints.WEST;
        sliderPanel.add(panel,gbc);
    }
}
