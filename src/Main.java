import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Main class is responsible for initializing various command objects
 * related to smart home functionalities and displaying a GUI representation
 * of the smart home system.
 */
public class Main {

    /**
     * The main method which is the entry point of the program.
     * This method initializes all the command objects associated with different
     * home devices like lights, TV, stereo, ceiling fan, etc. Then, it sets up
     * a GUI to visualize and control these devices.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        // Initialize various home devices and their corresponding command objects
        Light light = new Light("main");
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        Light livingroomLight = new Light("living room");
        Command livingroomLightOn = new LivingroomLightOnCommand(livingroomLight);
        Command livingroomLightOff = new LivingroomLightOffCommand(livingroomLight);
        GarageDoor garageDoor = new GarageDoor("Main");
        Command garageDoorUp = new GarageDoorUpCommand(garageDoor);
        Command garageDoorDown = new GarageDoorDownCommand(garageDoor);
        Command garageLightOn = new GarageLightOnCommand(garageDoor);
        Command garageLightOff = new GarageLightOffCommand(garageDoor);
        TV tv = new TV("Living Room");
        Command tvOnCommand = new TVOnCommand(tv);
        Command tvOffCommand = new TVOffCommand(tv);
        CeilingFan ceilingFan = new CeilingFan("Living Room");
        Command ceilingFanOn = new CeilingFanOnCommand(ceilingFan);
        Command ceilingFanOff = new CeilingFanOffCommand(ceilingFan);
        Command ceilingFanSpeed = new CeilingFanSpeedCommand(ceilingFan);
        Hottub hottub = new Hottub();
        Command hottubOn = new HottubOnCommand(hottub);
        Command hottubOff = new HottubOffCommand(hottub);
        Stereo livingRoomStereo = new Stereo("Living Room");
        Stereo bedroomStereo = new Stereo("Bedroom");
        Command livingRoomStereoOn = new StereoOnCommand(livingRoomStereo);
        Command livingRoomStereoOff = new StereoOffCommand(livingRoomStereo);
        Command bedroomStereoOn = new StereoOnCommand(bedroomStereo);
        Command bedroomStereoOff = new StereoOffCommand(bedroomStereo);
        Command livingRoomSetCD = new StereoSetCDCommand(livingRoomStereo);
        Command livingRoomSetDVD = new StereoSetDVDCommand(livingRoomStereo);
        Command livingRoomSetRadio = new StereoSetRadioCommand(livingRoomStereo, 94);
        Command livingRoomSetVolume = new StereoSetVolumeCommand(livingRoomStereo, 20);
        Command bedroomSetCD = new StereoSetCDCommand(bedroomStereo);
        Command bedroomSetDVD = new StereoSetDVDCommand(bedroomStereo);
        Command bedroomSetRadio = new StereoSetRadioCommand(bedroomStereo, 94);
        Command bedroomSetVolume = new StereoSetVolumeCommand(bedroomStereo, 20);
        SmartHome homeVisualization = new SmartHome();
        homeVisualization.setVisible(true);

        // Invoking the commands through a button GUI for interaction
        new ButtonInvoker(lightOn, lightOff, light, livingroomLightOn, livingroomLightOff, livingroomLight,
                garageDoorUp, garageDoorDown, garageLightOn, garageLightOff, garageDoor, tvOnCommand, tvOffCommand,
                tv, ceilingFanOn, ceilingFanOff, ceilingFanSpeed, ceilingFan, hottubOn, hottubOff, hottub, livingRoomStereoOn, livingRoomStereoOff, livingRoomStereo,
                bedroomStereoOn, bedroomStereoOff, bedroomStereo, livingRoomSetCD, livingRoomSetDVD, livingRoomSetVolume, livingRoomSetRadio,
                bedroomSetCD, bedroomSetDVD, bedroomSetRadio, bedroomSetVolume, homeVisualization);
    }
}
/**
 * The ButtonInvoker class acts as a user interface to control various components of a smart home.
 * This interface provides the user with a set of buttons to control different home appliances,
 * including lights, garage doors, TV, stereo, ceiling fan, and hottub.
 * This class is designed as an Observer and thus can be updated based on state changes of various home appliances.
 */
class ButtonInvoker implements Observer {
    private final JButton onButton;
    private final JButton offButton;
    private final SmartHomeCentral central;
    private final JButton livingroomOnButton;
    private final JButton livingroomOffButton;
    private final Light light;
    private final Light livingroomLight;
    private final JButton garageDoorUpButton;
    private final JButton garageDoorDownButton;
    private final JButton garageLightOnButton;
    private final JButton garageLightOffButton;
    private final Command garageDoorDownCommand;
    private final Command garageLightOnCommand;
    private final Command garageLightOffCommand;
    private final GarageDoor garageDoor;
    private final JButton tvOnButton;
    private final JButton tvOffButton;
    private final JButton tvSetChannelButton;
    private final Command tvOnCommand;
    private final Command tvOffCommand;
    private final TV tv;
    private final JTextField channelInputField;
    private final JButton ceilingFanOnButton;
    private final JButton ceilingFanOffButton;
    private final JButton ceilingFanSpeedButton;
    private final Command ceilingFanOnCommand;
    private final Command ceilingFanOffCommand;
    private final CeilingFan ceilingFan;
    private final Command ceilingFanSpeedCommand;
    private final Hottub hottub;
    private final Command hottubOnCommand;
    private final Command hottubOffCommand;
    private final JButton hottubOnButton;
    private final JButton hottubOffButton;
    private final JTextField temperatureField;
    private final JButton setTemperatureButton;
    private final Stereo livingRoomStereo;
    private final Stereo bedroomStereo;
    private final Command livingRoomStereoOnCommand;
    private final Command livingRoomStereoOffCommand;
    private final JButton livingRoomStereoOnButton;
    private final JButton livingRoomStereoOffButton;
    private final Command bedroomStereoOnCommand;
    private final Command bedroomStereoOffCommand;
    private final JButton bedroomStereoOnButton;
    private final JButton bedroomStereoOffButton;
    private final Command livingRoomSetCDCommand;
    private final Command livingRoomSetDVDCommand;
    private final Command livingRoomSetVolumeCommand;
    private final Command livingRoomSetRadioCommand;
    private final JButton livingRoomSetCDButton;
    private final JButton livingRoomSetDVDButton;
    private final JButton livingRoomSetVolumeButton;
    private final JButton livingRoomSetRadioButton;
    private final JTextField livingradioStationField;
    private final JSlider livingVolumeSlider;
    private final Command bedroomSetCDCommand;
    private final Command bedroomSetDVDCommand;
    private final Command bedroomSetVolumeCommand;
    private final Command bedroomSetRadioCommand;
    private final JButton bedroomSetCDButton;
    private final JButton bedroomSetDVDButton;
    private final JButton bedroomSetVolumeButton;
    private final JButton bedroomSetRadioButton;
    private final JTextField bedroomradioStationField;
    private final JSlider bedroomVolumeSlider;
    private final JButton vacationModeStartButton;
    private final SmartHome smartHome;
    /**
     * Constructor for the ButtonInvoker class, setting up the controls and registering
     * them with their corresponding commands and devices.
     */
    public ButtonInvoker(Command lightOnCommand, Command lightOffCommand, Light light,
                         Command livingroomLightOnCommand, Command livingroomLightOffCommand, Light livingroomLight,
                         Command garageDoorUpCommand, Command garageDoorDownCommand,
                         Command garageLightOnCommand, Command garageLightOffCommand, GarageDoor garageDoor,
                         Command tvOnCommand, Command tvOffCommand, TV tv, Command ceilingFanOnCommand,
                         Command ceilingFanOffCommand, Command ceilingFanSpeedCommand, CeilingFan ceilingFan, Command hottubOnCommand,
                         Command hottubOffCommand, Hottub hottub, Command livingRoomStereoOnCommand, Command livingRoomStereoOffCommand, Stereo livingRoomStereo,
                         Command bedroomStereoOnCommand, Command bedroomStereoOffCommand, Stereo bedroomStereo, Command livingRoomSetCDCommand, Command livingRoomSetDVDCommand,
                         Command livingRoomSetVolumeCommand, Command livingRoomSetRadioCommand, Command bedroomSetCDCommand, Command bedroomSetDVDCommand,
                         Command bedroomSetRadioCommand, Command bedroomSetVolumeCommand, SmartHome smartHome) {

        this.smartHome = smartHome;
        this.light = light;
        this.livingroomLight = livingroomLight;
        this.garageDoorDownCommand = garageDoorDownCommand;
        this.garageLightOnCommand = garageLightOnCommand;
        this.garageLightOffCommand = garageLightOffCommand;
        this.garageDoor = garageDoor;
        this.tvOnCommand = tvOnCommand;
        this.tvOffCommand = tvOffCommand;
        this.tv = tv;
        this.ceilingFan = ceilingFan;
        this.ceilingFanOnCommand = ceilingFanOnCommand;
        this.ceilingFanOffCommand = ceilingFanOffCommand;
        this.ceilingFanSpeedCommand = ceilingFanSpeedCommand;
        this.hottub = hottub;
        this.hottubOnCommand = hottubOnCommand;
        this.hottubOffCommand = hottubOffCommand;
        this.livingRoomStereoOnCommand = livingRoomStereoOnCommand;
        this.livingRoomStereoOffCommand = livingRoomStereoOffCommand;
        this.livingRoomSetCDCommand = livingRoomSetCDCommand;
        this.livingRoomSetDVDCommand = livingRoomSetDVDCommand;
        this.livingRoomSetRadioCommand = livingRoomSetRadioCommand;
        this.livingRoomSetVolumeCommand = livingRoomSetVolumeCommand;
        this.livingRoomStereo = livingRoomStereo;
        this.bedroomSetCDCommand = bedroomSetCDCommand;
        this.bedroomSetDVDCommand = bedroomSetDVDCommand;
        this.bedroomSetRadioCommand = bedroomSetRadioCommand;
        this.bedroomSetVolumeCommand = bedroomSetVolumeCommand;
        this.bedroomStereoOnCommand = bedroomStereoOnCommand;
        this.bedroomStereoOffCommand = bedroomStereoOffCommand;
        this.bedroomStereo = bedroomStereo;
        central = SmartHomeCentral.getInstance();


        JFrame frame = new JFrame("Smart Home Control");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        onButton = new JButton("Turn ON Light");
        offButton = new JButton("Turn OFF Light");
        offButton.setEnabled(false);
        light.registerObserver(this);
        light.registerObserver(smartHome);

        livingroomOnButton = new JButton("Turn ON Livingroom Light");
        livingroomOffButton = new JButton("Turn OFF Livingroom Light");
        livingroomOffButton.setEnabled(false);
        livingroomLight.registerObserver(this);
        livingroomLight.registerObserver(smartHome);

        garageDoorUpButton = new JButton("Open Garage Door");
        garageDoorDownButton = new JButton("Close Garage Door");
        garageDoorDownButton.setEnabled(false);
        garageLightOnButton = new JButton("Garage Light ON");
        garageLightOffButton = new JButton("Garage Light OFF");
        garageLightOffButton.setEnabled(false);
        garageDoor.registerObserver(this);
        garageDoor.registerObserver(smartHome);

        tvOnButton = new JButton("Turn ON TV");
        tvOffButton = new JButton("Turn OFF TV");
        tvSetChannelButton = new JButton("Set TV Channel");
        tvOffButton.setEnabled(false);
        tvSetChannelButton.setEnabled(tv.isOn());
        channelInputField = new JTextField("Channel", 10);
        tv.registerObserver(this);
        tv.registerObserver(smartHome);

        ceilingFanOnButton = new JButton("Turn ON Ceiling Fan");
        ceilingFanOffButton = new JButton("Turn OFF Ceiling Fan");
        ceilingFanSpeedButton = new JButton("Change Ceiling Fan Speed");
        ceilingFanOffButton.setEnabled(false);
        ceilingFanSpeedButton.setEnabled(false);
        ceilingFan.registerObserver(this);
        ceilingFan.registerObserver(smartHome);

        hottubOnButton = new JButton("Turn ON Hottub");
        hottubOffButton = new JButton("Turn OFF Hottub");
        temperatureField = new JTextField("Temperature", 10);
        setTemperatureButton = new JButton("Set Temperature");
        hottubOffButton.setEnabled(false);
        setTemperatureButton.setEnabled(false);
        hottub.registerObserver(this);
        hottub.registerObserver(smartHome);

        livingRoomStereoOnButton = new JButton("Turn ON Living Room Stereo");
        livingRoomStereoOffButton = new JButton("Turn OFF Living Room Stereo");
        livingRoomStereoOffButton.setEnabled(false);
        livingRoomSetCDButton = new JButton("Set Living Room CD");
        livingRoomSetDVDButton = new JButton("Set Living Room DVD");
        livingRoomSetRadioButton = new JButton ("Set Living Room Radio");
        livingRoomSetVolumeButton = new JButton ("Set Living Room Volume");
        livingradioStationField = new JTextField("Station", 10);
        livingVolumeSlider = new JSlider(JSlider.HORIZONTAL, 1, 11, 5);
        livingRoomSetCDButton.setEnabled(false);
        livingRoomSetDVDButton.setEnabled(false);
        livingRoomSetRadioButton.setEnabled(false);
        livingRoomSetVolumeButton.setEnabled(false);
        livingRoomStereo.registerObserver(this);
        livingRoomStereo.registerObserver(smartHome);

        bedroomStereoOnButton = new JButton("Turn ON Bedroom Stereo");
        bedroomStereoOffButton = new JButton("Turn OFF Bedroom Stereo");
        bedroomStereoOffButton.setEnabled(false);
        bedroomSetCDButton = new JButton("Set Bedroom CD");
        bedroomSetDVDButton = new JButton("Set Bedroom DVD");
        bedroomSetRadioButton = new JButton ("Set Bedroom Radio");
        bedroomSetVolumeButton = new JButton ("Set Bedroom Volume");
        bedroomradioStationField = new JTextField("Station", 10);
        bedroomVolumeSlider = new JSlider(JSlider.HORIZONTAL, 1, 11, 5);
        bedroomSetCDButton.setEnabled(false);
        bedroomSetDVDButton.setEnabled(false);
        bedroomSetRadioButton.setEnabled(false);
        bedroomSetVolumeButton.setEnabled(false);
        bedroomStereo.registerObserver(this);
        bedroomStereo.registerObserver(smartHome);

        vacationModeStartButton = new JButton("Start Vacation Mode");

        vacationModeStartButton.addActionListener(e -> {
            central.startVacationMode();
        });
        onButton.addActionListener(e -> {
            central.addCommand(lightOnCommand);
        });
        offButton.addActionListener(e ->{
            central.addCommand(lightOffCommand);
        });
        JButton undoButton = new JButton("Undo Last Action");
        undoButton.addActionListener(e -> {
            central.undoLastCommand();
        });
        livingroomOnButton.addActionListener(e -> {
            central.addCommand(livingroomLightOnCommand);
        });
        livingroomOffButton.addActionListener(e -> {
            central.addCommand(livingroomLightOffCommand);
        });
        garageDoorUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                central.addCommand(garageDoorUpCommand);
            }
        });
        garageDoorDownButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                central.addCommand(garageDoorDownCommand);
            }
        });
        garageLightOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                central.addCommand(garageLightOnCommand);
            }
        });
        garageLightOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                central.addCommand(garageLightOffCommand);
            }
        });
        tvOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                central.addCommand(tvOnCommand);
            }
        });
        tvOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                central.addCommand(tvOffCommand);
            }
        });
        tvSetChannelButton.addActionListener(e -> {
            try {
                int channelNumber = Integer.parseInt(channelInputField.getText());
                central.addCommand(new TVSetInputChannelCommand(tv, channelNumber));
            } catch (NumberFormatException ex) {
                System.out.println("Invalid channel number");
            }
        });
        ceilingFanOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                central.addCommand(ceilingFanOnCommand);
            }
        });
        ceilingFanOffButton.addActionListener(e ->{
            central.addCommand(ceilingFanOffCommand);
        });
        ceilingFanSpeedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                central.addCommand(new CeilingFanSpeedCommand(ceilingFan));

            }
        });
        hottubOnButton.addActionListener(e -> {
            central.addCommand(hottubOnCommand);
        });
        hottubOffButton.addActionListener(e -> {
            central.addCommand(hottubOffCommand);
        });
        setTemperatureButton.addActionListener(e -> {
            if (hottub.on) {
                try {
                    int temp = Integer.parseInt(temperatureField.getText());
                    System.out.println("Setting hottub temperature to: " + temp);
                    hottub.setTemperature(temp);
                } catch (NumberFormatException ex) {
                    System.out.println("Error: Invalid temperature input.");
                }
            } else {
                System.out.println("Hottub is off.");
            }
        });
        livingRoomStereoOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                central.addCommand(livingRoomStereoOnCommand);
            }
        });
        livingRoomStereoOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                central.addCommand(livingRoomStereoOffCommand);
            }
        });
        livingRoomSetCDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                central.addCommand(livingRoomSetCDCommand);
            }
        });
        livingRoomSetDVDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                central.addCommand(livingRoomSetDVDCommand);
            }
        });
        livingRoomSetRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String stationText = livingradioStationField.getText().trim();
                if (!stationText.isEmpty()) {
                    try {
                        float station = Float.parseFloat(stationText);
                        Command setRadio = new StereoSetRadioCommand(livingRoomStereo, station);
                        central.addCommand(setRadio);
                    } catch (NumberFormatException ex) {
                        System.out.println("Please introduce a valid frequency.");
                    }
                } else {
                    System.out.println("The field cannot be empty.");
                }
            }
        });
        livingRoomSetVolumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int volume = livingVolumeSlider.getValue();
                Command setVolume = new StereoSetVolumeCommand(livingRoomStereo, volume);
                central.addCommand(setVolume);
            }
        });
        bedroomStereoOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                central.addCommand(bedroomStereoOnCommand);
            }
        });
        bedroomStereoOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                central.addCommand(bedroomStereoOffCommand);
            }
        });
        bedroomSetCDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                central.addCommand(bedroomSetCDCommand);
            }
        });
        bedroomSetDVDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                central.addCommand(bedroomSetDVDCommand);
            }
        });
        bedroomSetRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String stationText = bedroomradioStationField.getText().trim();
                if (!stationText.isEmpty()) {
                    try {
                        float station = Float.parseFloat(stationText);
                        Command setRadio = new StereoSetRadioCommand(bedroomStereo, station);
                        central.addCommand(setRadio);
                    } catch (NumberFormatException ex) {
                        System.out.println("Please introduce a valid frequency.");
                    }
                } else {
                    System.out.println("The field cannot be empty.");
                }
            }
        });
        bedroomSetVolumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int volume = bedroomVolumeSlider.getValue();
                Command setVolume = new StereoSetVolumeCommand(bedroomStereo, volume);
                central.addCommand(setVolume);
            }
        });


        JPanel lightPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lightPanel.setBorder(BorderFactory.createTitledBorder("Light"));
        lightPanel.add(onButton);
        lightPanel.add(offButton);
        lightPanel.add(livingroomOnButton);
        lightPanel.add(livingroomOffButton);

        JPanel garagePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        garagePanel.setBorder(BorderFactory.createTitledBorder("Garage"));
        garagePanel.add(garageDoorUpButton);
        garagePanel.add(garageDoorDownButton);
        garagePanel.add(garageLightOnButton);
        garagePanel.add(garageLightOffButton);

        JPanel tvPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        tvPanel.setBorder(BorderFactory.createTitledBorder("TV"));
        tvPanel.add(tvOnButton);
        tvPanel.add(tvOffButton);
        tvPanel.add(channelInputField);
        tvPanel.add(tvSetChannelButton);

        JPanel fanPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fanPanel.setBorder(BorderFactory.createTitledBorder("Ceiling Fan"));
        fanPanel.add(ceilingFanOnButton);
        fanPanel.add(ceilingFanOffButton);
        fanPanel.add(ceilingFanSpeedButton);

        JPanel hottubPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        hottubPanel.setBorder(BorderFactory.createTitledBorder("Hottub"));
        hottubPanel.add(hottubOnButton);
        hottubPanel.add(hottubOffButton);
        hottubPanel.add(temperatureField);
        hottubPanel.add(setTemperatureButton);

        JPanel livingStereoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        livingStereoPanel.setBorder(BorderFactory.createTitledBorder("Stereo - Living Room"));
        livingStereoPanel.add(livingRoomStereoOnButton);
        livingStereoPanel.add(livingRoomStereoOffButton);
        livingStereoPanel.add(livingRoomSetCDButton);
        livingStereoPanel.add(livingRoomSetDVDButton);
        livingStereoPanel.add(livingRoomSetRadioButton);
        livingStereoPanel.add(livingRoomSetVolumeButton);
        livingStereoPanel.add(livingradioStationField);
        livingStereoPanel.add(livingVolumeSlider);

        JPanel bedroomStereoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bedroomStereoPanel.setBorder(BorderFactory.createTitledBorder("Stereo - Bedroom"));
        bedroomStereoPanel.add(bedroomStereoOnButton);
        bedroomStereoPanel.add(bedroomStereoOffButton);
        bedroomStereoPanel.add(bedroomSetCDButton);
        bedroomStereoPanel.add(bedroomSetDVDButton);
        bedroomStereoPanel.add(bedroomSetRadioButton);
        bedroomStereoPanel.add(bedroomSetVolumeButton);
        bedroomStereoPanel.add(bedroomradioStationField);
        bedroomStereoPanel.add(bedroomVolumeSlider);

        JPanel miscPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        miscPanel.add(vacationModeStartButton);
        miscPanel.add(undoButton);

        frame.add(lightPanel);
        frame.add(garagePanel);
        frame.add(tvPanel);
        frame.add(fanPanel);
        frame.add(hottubPanel);
        frame.add(livingStereoPanel);
        frame.add(bedroomStereoPanel);
        frame.add(miscPanel);
        frame.setVisible(true);
    }
    /**
     * Implementation of the update function that is invoked when the state of a device changes
     */
    @Override
    public void update(Object obj1, Object obj2) {
        if (!(obj2 instanceof Boolean)) {
            return;
        }
        boolean state = (Boolean) obj2;

        if (obj1 == light) {
            onButton.setEnabled(!state);
            offButton.setEnabled(state);
        } else if (obj1 == livingroomLight) {
            livingroomOnButton.setEnabled(!state);
            livingroomOffButton.setEnabled(state);
        } else if (obj1 == tv) {
            tvOnButton.setEnabled(!state);
            tvOffButton.setEnabled(state);
            tvSetChannelButton.setEnabled(state);
        } else if (obj1 == garageDoor) {
            garageDoorUpButton.setEnabled(!garageDoor.isDoorOpen());
            garageDoorDownButton.setEnabled(garageDoor.isDoorOpen());
            garageLightOnButton.setEnabled(!garageDoor.isLightOn());
            garageLightOffButton.setEnabled(garageDoor.isLightOn());
        } else if (obj1 == ceilingFan) {
            if (ceilingFan.getSpeed() == CeilingFan.OFF) {
                ceilingFanOnButton.setEnabled(!state);
                ceilingFanOffButton.setEnabled(state);
                ceilingFanSpeedButton.setEnabled(state);
            } else {
                ceilingFanOnButton.setEnabled(!state);
                ceilingFanOffButton.setEnabled(state);
                ceilingFanSpeedButton.setEnabled(true);
            }
        } else if (obj1 == hottub) {
            hottubOnButton.setEnabled(!state);
            hottubOffButton.setEnabled(state);
            setTemperatureButton.setEnabled(state);
        } else if (obj1 == livingRoomStereo) {
            livingRoomStereoOnButton.setEnabled(!state);
            livingRoomStereoOffButton.setEnabled(state);
            livingRoomSetCDButton.setEnabled(state);
            livingRoomSetDVDButton.setEnabled(state);
            livingRoomSetRadioButton.setEnabled(state);
            livingRoomSetVolumeButton.setEnabled(state);
        } else if (obj1 == bedroomStereo) {
            bedroomStereoOnButton.setEnabled(!state);
            bedroomStereoOffButton.setEnabled(state);
            bedroomSetCDButton.setEnabled(state);
            bedroomSetDVDButton.setEnabled(state);
            bedroomSetRadioButton.setEnabled(state);
            bedroomSetVolumeButton.setEnabled(state);
        }
    }
}