import javax.swing.*;
import java.awt.*;

/**
 * Represents a smart home GUI where the state of various home appliances
 * can be visually represented.
 */
public class SmartHome extends JFrame implements Observer {
    private static final int NEW_WIDTH = 640;
    private static final int NEW_HEIGHT = 480;
    private ImageIcon homeImageIcon;

    // State variables for various devices
    private boolean isLightOn = false;
    private boolean isLivingRoomLightOn = false;
    private boolean isGarageLightOn = false;
    private boolean isGarageDoorOpen = false;
    private boolean isTVon = false;
    private boolean isCeilingFanOn = false;
    private boolean isHottubOn = false;
    private boolean isLivingStereoOn = false;
    private boolean isBedroomStereoOn = false;

    /**
     * Initializes the smart home GUI.
     */
    public SmartHome() {
        setTitle("Smart Home");
        setSize(640, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        homeImageIcon = new ImageIcon("src/casa.jpg");
        Image image = homeImageIcon.getImage();

        // Canvas for drawing the smart home layout
        JPanel canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image scaledImage = image.getScaledInstance(NEW_WIDTH, NEW_HEIGHT, Image.SCALE_SMOOTH);
                homeImageIcon = new ImageIcon(scaledImage);
                g.drawImage(scaledImage, 0, 0, this);
                g.drawImage(homeImageIcon.getImage(), 0, 0, this);
                if (isLightOn) {
                    g.setColor(Color.YELLOW);
                    g.fillOval(320, 80, 10, 10);
                } else {
                    g.setColor(Color.BLACK);
                    g.fillOval(320, 80, 10, 10);
                }
                if (isLivingRoomLightOn) {
                    g.setColor(Color.YELLOW);
                    g.fillOval(220, 220, 10, 10);
                } else {
                    g.setColor(Color.BLACK);
                    g.fillOval(220, 220, 10, 10);
                }
                if (isGarageLightOn) {
                    g.setColor(Color.YELLOW);
                    g.fillOval(220, 340, 10, 10);
                } else {
                    g.setColor(Color.BLACK);
                    g.fillOval(220, 340, 10, 10);
                }
                if (isGarageDoorOpen) {
                    g.setColor(Color.BLUE);
                    g.fillOval(150, 380, 10, 10);
                    g.setFont(new Font("SansSerif", Font.BOLD, 14));
                    g.drawString("Door Open", 130, 370);
                } else {
                    g.setColor(Color.CYAN);
                    g.fillOval(150, 380, 10, 10);
                    g.setFont(new Font("SansSerif", Font.BOLD, 14));
                    g.drawString("Door close", 130, 370);
                }
                if (isTVon) {
                    g.setColor(Color.PINK);
                    g.fillOval(150, 220, 10, 10);
                    g.setFont(new Font("SansSerif", Font.BOLD, 14));
                    g.drawString("TV is on", 130, 210);
                } else {
                    g.setColor(Color.RED);
                    g.fillOval(150, 220, 10, 10);
                    g.setFont(new Font("SansSerif", Font.BOLD, 14));
                    g.drawString("TV is off", 130, 210);
                }
                if (isCeilingFanOn) {
                    g.setColor(Color.BLUE);
                    g.fillOval(190, 150, 10, 10);
                    g.setFont(new Font("SansSerif", Font.BOLD, 14));
                    g.drawString("Ceiling Fan is on", 90, 140);
                } else {
                    g.setColor(Color.GRAY);
                    g.fillOval(190, 150, 10, 10);
                    g.setFont(new Font("SansSerif", Font.BOLD, 14));
                    g.drawString("Ceiling Fan is off", 90, 140);
                }
                if (isHottubOn) {
                    g.setColor(Color.GREEN);
                    g.fillOval(460, 280, 10, 10);
                    g.setFont(new Font("SansSerif", Font.BOLD, 14));
                    g.drawString("Hottub is on", 400, 240);
                } else {
                    g.setColor(Color.BLACK);
                    g.fillOval(460, 280, 10, 10);
                    g.setFont(new Font("SansSerif", Font.BOLD, 14));
                    g.drawString("Hottub is off", 400, 240);
                }
                if (isBedroomStereoOn) {
                    g.setColor(Color.MAGENTA);
                    g.fillOval(400, 160, 10, 10);
                    g.setFont(new Font("SansSerif", Font.BOLD, 14));
                    g.drawString("The stereo is on", 350, 130);
                } else {
                    g.setColor(Color.PINK);
                    g.fillOval(400, 160, 10, 10);
                    g.setFont(new Font("SansSerif", Font.BOLD, 14));
                    g.drawString("The stereo is off", 350, 130);
                }

                if (isLivingStereoOn) {
                    g.setColor(Color.MAGENTA);
                    g.fillOval(270, 280, 10, 10);
                    g.setFont(new Font("SansSerif", Font.BOLD, 14));
                    g.drawString("The stereo is on", 240, 250);
                } else {
                    g.setColor(Color.PINK);
                    g.fillOval(270, 280, 10, 10);
                    g.setFont(new Font("SansSerif", Font.BOLD, 14));
                    g.drawString("The stereo is off", 240, 250);
                }
            }
        };
        add(canvas, BorderLayout.CENTER);
    }

    /**
     * Helper methods to update the GUI based on device states
     */
    public void setLightOn() {
        this.isLightOn = true;
        repaint();
    }
    public void setLightOff() {
        this.isLightOn = false;
        repaint();
    }
    public void setLivingRoomLightOn() {
        this.isLivingRoomLightOn = true;
        repaint();
    }
    public void setLivingRoomLightOff() {
        this.isLivingRoomLightOn = false;
        repaint();
    }
    public void setGarageLightOn() {
        this.isGarageLightOn = true;
        repaint();
    }
    public void setGarageLightOff() {
        this.isGarageLightOn = false;
        repaint();
    }
    public void setGarageDoorOpen() {
        this.isGarageDoorOpen = true;
        repaint();
    }
    public void setGarageDoorClose() {
        this.isGarageDoorOpen = false;
        repaint();
    }
    public void setTVon() {
        this.isTVon = true;
        repaint();
    }
    public void setTVoff() {
        this.isTVon = false;
        repaint();
    }
    public void setCeilingFanOn() {
        this.isCeilingFanOn = true;
        repaint();
    }
    public void setCeilingFanOff() {
        this.isCeilingFanOn = false;
        repaint();
    }
    public void setHottubOn() {
        this.isHottubOn = true;
        repaint();
    }
    public void setHottubOff() {
        this.isHottubOn = false;
        repaint();
    }
    public void setLivingStereoOn() {
        this.isLivingStereoOn = true;
        repaint();
    }
    public void setLivingStereoOff() {
        this.isLivingStereoOn = false;
        repaint();
    }
    public void setBedroomStereoOn() {
        this.isBedroomStereoOn = true;
        repaint();
    }
    public void setBedroomStereoOff() {
        this.isBedroomStereoOn = false;
        repaint();
    }
    /**
     * Updates the GUI based on the changes in the state of observed subjects.
     * @param subject The subject being observed.
     * @param arg The argument passed by the observed subject during notification.
     */
    @Override
    public void update(Object subject, Object arg) {
        // Logic to update device state based on the observed subject
        if (subject instanceof Light && arg instanceof Boolean) {
            boolean lightStatus = (Boolean) arg;
            Light light = (Light) subject;
            switch (light.getIdentifier()) {
                case "main":
                    if (lightStatus) {
                        setLightOn();
                    } else {
                        setLightOff();
                    }
                    break;
                case "living room":
                    if (lightStatus) {
                        setLivingRoomLightOn();
                    } else {
                        setLivingRoomLightOff();
                    }
                    break;
            }
        } else if (subject instanceof GarageDoor && arg instanceof Object[]) {
            Object[] garageData = (Object[]) arg;
            String type = (String) garageData[0];
            boolean status = (Boolean) garageData[1];
            if ("door".equals(type)) {
                if (status) {
                    setGarageDoorOpen();
                } else {
                    setGarageDoorClose();
                }
            } else if ("light".equals(type)) {
                if (status) {
                    setGarageLightOn();
                } else {
                    setGarageLightOff();
                }
            }
        }
        else if (subject instanceof TV && arg instanceof Boolean) {
            boolean tvStatus = (Boolean) arg;
            if (tvStatus) {
                setTVon();
            } else {
                setTVoff();
            }
        }
        else if (subject instanceof CeilingFan && arg instanceof Boolean) {
            boolean ceilingFanStatus = (Boolean) arg;
            if (ceilingFanStatus) {
                setCeilingFanOn();
            } else {
                setCeilingFanOff();
            }
        }
        else if (subject instanceof Hottub && arg instanceof Boolean) {
            boolean hottubStatus = (Boolean) arg;
            if (hottubStatus) {
                setHottubOn();
            } else {
                setHottubOff();
            }
        }
        else if (subject instanceof Stereo && arg instanceof Boolean) {
            boolean stereoStatus = (Boolean) arg;
            Stereo stereo = (Stereo) subject;
            if ("Living Room".equals(stereo.getLocation())) {
                if (stereoStatus) {
                    setLivingStereoOn();
                } else {
                    setLivingStereoOff();
                }
            } else if ("Bedroom".equals(stereo.getLocation())) {
                if (stereoStatus) {
                    setBedroomStereoOn();
                } else {
                    setBedroomStereoOff();
                }
            }
        }
    }
}