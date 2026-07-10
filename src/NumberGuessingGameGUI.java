import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

public class NumberGuessingGameGUI extends JFrame implements ActionListener {

    private JLabel title, message, attempts, bestScore, remaining,currentScore;
    private JTextField input;
    private JButton guessBtn, playBtn,leaderboardBtn;
    private JComboBox<String> difficultyBox;

    private JPanel root;

    private boolean playerWon = false;
    private boolean gameOver = false;
    private boolean warmer = false;
    private boolean cooler = false;

    private Game game;


    public NumberGuessingGameGUI() {

        setTitle("Number Guessing Game");

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // ================= BACKGROUND =================

        root = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);

                Graphics2D g2d = (Graphics2D) g;

                Color top;
                Color bottom;

                if(playerWon){

                    top = new Color(46,204,113);
                    bottom = new Color(39,174,96);

                }

                else if(gameOver){

                    top = new Color(192,57,43);
                    bottom = new Color(231,76,60);

                }

                else if(warmer){

                   
                    top = new Color(255,120,40);
                    bottom = new Color(255,180,80);

                }

                else if(cooler){

                    top = new Color(0,100,255);
                    bottom = new Color(100,200,255);

                }

                else{

                    top = new Color(5,5,20);
                    bottom = new Color(0,150,255);

                }


                GradientPaint gp = new GradientPaint(
                        0,
                        0,
                        top,
                        0,
                        getHeight(),
                        bottom
                );


                g2d.setPaint(gp);

                g2d.fillRect(
                        0,
                        0,
                        getWidth(),
                        getHeight()
                );

            }
        };


        root.setLayout(new GridBagLayout());


        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;

        gbc.insets = new Insets(15,15,15,15);



        // ================= TITLE =================


        title = new JLabel("NUMBER GUESSING GAME");

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        42
                )
        );

        title.setForeground(Color.WHITE);


        gbc.gridy = 0;

        root.add(title, gbc);



        // ================= MESSAGE =================


        message = new JLabel(
                "Guess a number between 1 and 100"
        );


        message.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        22
                )
        );


        message.setForeground(Color.WHITE);


        gbc.gridy = 1;

        root.add(message, gbc);

        // ================= DIFFICULTY =================


        difficultyBox = new JComboBox<>(
                new String[]{"Easy","Hard"}
        );


        difficultyBox.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );


        difficultyBox.setPreferredSize(
                new Dimension(180,45)
        );


        gbc.gridy = 2;

        root.add(difficultyBox, gbc);


        // ================= INPUT =================


        input = new JTextField();


        input.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        22
                )
        );


        input.setPreferredSize(
                new Dimension(260,45)
        );


        gbc.gridy = 3;

        root.add(input, gbc);

        // ================= BUTTONS =================


        guessBtn = new JButton("Guess");

        playBtn = new JButton("Play Again");
        leaderboardBtn = new JButton("Leaderboard");


        Font buttonFont =
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                );


        guessBtn.setFont(buttonFont);

        playBtn.setFont(buttonFont);
        leaderboardBtn.setFont(buttonFont);

     // BUTTON COLORS

        guessBtn.setBackground(
                new Color(0,180,255)
        ); 


        playBtn.setBackground(
                new Color(0,220,120)
        ); 


        leaderboardBtn.setBackground(
        		 new Color(255,170,0)
        );


        guessBtn.setForeground(Color.WHITE);
        playBtn.setForeground(Color.WHITE);
        leaderboardBtn.setForeground(Color.WHITE);


        guessBtn.setFocusPainted(false);

        playBtn.setFocusPainted(false);
        leaderboardBtn.setFocusPainted(false);

        guessBtn.setBorder(
                BorderFactory.createEmptyBorder()
        );

        playBtn.setBorder(
                BorderFactory.createEmptyBorder()
        );
        leaderboardBtn.setBorder(
                BorderFactory.createEmptyBorder()
        );


        guessBtn.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );


        playBtn.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );
        leaderboardBtn.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        Dimension buttonSize = new Dimension(190,50);


        guessBtn.setPreferredSize(buttonSize);

        playBtn.setPreferredSize(buttonSize);

        leaderboardBtn.setPreferredSize(buttonSize);


        JPanel buttonPanel = new JPanel();

        buttonPanel.setOpaque(false);


        buttonPanel.add(guessBtn);

        buttonPanel.add(
                Box.createHorizontalStrut(20)
        );

        buttonPanel.add(playBtn);

        buttonPanel.add(
                Box.createHorizontalStrut(20)
        );

        buttonPanel.add(leaderboardBtn);

        gbc.gridy = 4;

        root.add(buttonPanel, gbc);
        // ================= STATS =================

        attempts = new JLabel("Attempts : 0");
        remaining = new JLabel("");
        currentScore = new JLabel("");
        bestScore = new JLabel("Best Score : 0");


        Font statsFont = new Font(
                "Segoe UI",
                Font.BOLD,
                20
        );


        attempts.setFont(statsFont);
        remaining.setFont(statsFont);
        currentScore.setFont(statsFont);
        bestScore.setFont(statsFont);


        attempts.setForeground(Color.WHITE);
        remaining.setForeground(Color.WHITE);
        currentScore.setForeground(Color.WHITE);
        bestScore.setForeground(new Color(255,215,0));


        gbc.gridy = 5;
        root.add(attempts, gbc);


        gbc.gridy = 6;
        root.add(remaining, gbc);
        gbc.gridy = 7;
        root.add(currentScore, gbc);


        gbc.gridy = 8;
        root.add(bestScore, gbc);

        add(root);

        // ================= GAME START =================

        game = new Game(
                (String)difficultyBox.getSelectedItem()
        );

        guessBtn.addActionListener(this);
        playBtn.addActionListener(this);
        leaderboardBtn.addActionListener(this);
        difficultyBox.addActionListener(this);


        updateLabels();
        updateBestScore();

        setVisible(true);

    }

     private void updateLabels(){

        remaining.setText(
                "Remaining Attempts : "
                + game.getRemainingAttempts()
        );

    }
    private void updateBestScore(){

        ArrayList<Integer> scores = ScoreManager.loadScores();

        if(scores.size() > 0){

            bestScore.setText(
                    "Best Score : " + scores.get(0)
            );

        }

    }


    @Override
    public void actionPerformed(ActionEvent e){


        // ================= GUESS BUTTON =================


        if(e.getSource() == guessBtn){


            try{
            	
                int guess =
                        Integer.parseInt(
                                input.getText()
                        );


                String result =
                        game.checkGuess(guess);
                if(result.contains("Warmer")){

                    warmer = true;
                    cooler = false;

                }

                else if(result.contains("Cooler")){

                    cooler = true;
                    warmer = false;

                }

                else{

                    warmer = false;
                    cooler = false;

                }

                root.repaint();



                attempts.setText(
                        "Attempts : "
                        + game.getAttempts()
                );


                updateLabels();



                if(result.equals("Too Low!")){


                    message.setText(
                            "⬆ Too Low! Try Again"
                    );


                }


                else if(result.equals("Too High!")){


                    message.setText(
                            "⬇ Too High! Try Again"
                    );


                }


                else if(result.equals("Correct!")){


                    playerWon = true;

                    gameOver = false;

                    root.repaint();


                    message.setText(
                            "Correct! You Win!"
                    );


                    int used = game.getAttempts();

                    int score = 
                            (game.getRemainingAttempts() + 1) * 10;
                    currentScore.setText(
                            "Current Score : " + score
                    );


                    ScoreManager.saveScore(score);

                    ArrayList<Integer> scores = ScoreManager.loadScores();
                    if(scores.size() > 0){

                        bestScore.setText(
                                "Best Score : " + scores.get(0)
                        );

                    }

                    String leaderboard = "<html>TOP 5 BEST SCORES<br>";

                    for(int i = 0; i < scores.size(); i++){

                        leaderboard += (i + 1) + ". " + scores.get(i) + "<br>";

                    }

                    leaderboard += "</html>";

                  
                    JOptionPane.showMessageDialog(
                            this,
                            "Congratulations!\n\nYou guessed the number!"
                            + "\n\nAttempts Used : " + used
                            + "\n\nScore : " + score,
                            "Winner",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    guessBtn.setEnabled(false);

                }


                else{


                    message.setText(result);

                }

                // ================= GAME OVER =================


                if(game.isGameOver()
                        && !result.equals("Correct!")){


                    gameOver = true;

                    playerWon = false;

                    root.repaint();


                    JOptionPane.showMessageDialog(
                            this,
                            "Game Over!\n\nThe number was : "
                            + game.getTargetNumber()
                            + "\n\nCurrent Score : 0",
                            "Game Over",
                            JOptionPane.ERROR_MESSAGE
                    );

                    message.setText(
                            "Game Over!"
                    );
                    currentScore.setText(
                            "Current Score : 0"
                    );


                    guessBtn.setEnabled(false);

                }

                input.setText("");


            }

            catch(NumberFormatException ex){


                message.setText(
                        "Please enter a valid number!"
                );


            }

        }

        // ================= PLAY AGAIN =================


        else if(e.getSource() == playBtn){


            playerWon = false;

            gameOver = false;
            warmer = false;
            cooler = false;

            root.repaint();



            game = new Game(
                    (String)difficultyBox.getSelectedItem()
            );



            guessBtn.setEnabled(true);



            input.setText("");



            message.setText(
                    "Guess a number between 1 and 100"
            );



            attempts.setText(
                    "Attempts : 0"
            		
            );
            currentScore.setText("");



            updateLabels();

        }


 // ================= DIFFICULTY CHANGE =================


        else if(e.getSource() == difficultyBox){


            playerWon = false;

            gameOver = false;
            warmer = false;
            cooler = false;

            root.repaint();



            game = new Game(
                    (String)difficultyBox.getSelectedItem()
            );

            guessBtn.setEnabled(true);

            input.setText("");

            message.setText(
                    "Guess a number between 1 and 100"
            );



            attempts.setText(
                    "Attempts : 0"
            );
            currentScore.setText("");

            updateLabels();

        }
        else if(e.getSource() == leaderboardBtn){


            ArrayList<Integer> scores = ScoreManager.loadScores();


            String leaderboard = "TOP 5 BEST SCORES\n\n";


            for(int i = 0; i < scores.size(); i++){

                leaderboard += 
                        (i + 1) + ". " + scores.get(i) + "\n";

            }


            JOptionPane.showMessageDialog(
                    this,
                    leaderboard,
                    "Leaderboard",
                    JOptionPane.INFORMATION_MESSAGE
            );

        }


    }


    public static void main(String[] args){


        SwingUtilities.invokeLater(
                () -> new NumberGuessingGameGUI()
        );


    }

}