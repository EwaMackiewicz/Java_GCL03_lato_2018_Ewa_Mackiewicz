/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package view;


import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;




public class MyApplet extends javax.swing.JApplet {

    private SearchProgress searchTask;
    private MoveProgress moveTask;
    private String mySign, opponentSign;
    private boolean end= false;
    private boolean opponentType; // if true->person if false AI
    private JButton buttons[][];
    private int x,y,z;
    private  int coordinate[]= new int[2];

    private Controller controller=new Controller();
    private int idGame;
    private String nick;
    private String password;
    private boolean creator;
    int numberMove=0;

    class SearchProgress extends SwingWorker <Void, Void> {

        public SearchProgress() {
        }

        @Override
        protected Void doInBackground() throws InterruptedException {
            progressBar.setIndeterminate(true);
            boolean d=false;


            while(!d)
            {
                Thread.sleep(1000);
                d=controller.waitFor2Player();

                System.out.print("szuka");
            }

            return null;
        }

        @Override
        protected void done()
        {
            progressBar.setIndeterminate(false);
            createBoard();
            System.out.print("znalazło kurwa");
        }
    }
    class MoveProgress extends SwingWorker <Void, Void> {

        private int ip,jp;
        public MoveProgress(int i,int j) {
            this.ip=i;
            this.jp=j;
        }

        protected Void doInBackground() throws InterruptedException {

            boolean d=false;

            controller.saveMove(ip,jp,mySign);


            while(!d)
            {
                //Thread.sleep(500);
                d=controller.waitForMove();

                System.out.println("czeka na ruch myaplet ");
            }


            System.out.println("jest");

            return null;
        }

        @Override
        protected void done()
        {


            controller.getMoveMaxId();
            coordinate=controller.getCoordinate();

            System.out.println("jest ruch kurwa aplet");
            buttons[coordinate[0]][coordinate[1]].setText(controller.getLastSign());
        }



    }
    private void createBoard()
    {
        buttonsPanel.setLayout(new GridLayout(x,y));
        buttons= new JButton[x][y];
        for(int i=0;i<x;i++)
        {
            for(int j=0;j<y;j++)
            {
                buttons[i][j]=new JButton();
                buttonsPanel.add(buttons[i][j]);
                buttons[i][j].setText(" ");
                buttons[i][j].addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        try {
                            mainActionPerformed(evt);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(MyApplet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            }

            ((CardLayout)this.displayPanel.getLayout()).show(displayPanel, "gameCard");
        }
    }
    public  void init() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbius (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the applet */
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    initComponents();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method is called from within the init() method to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupAiOrPerson = new javax.swing.ButtonGroup();
        buttonGroupOorX = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        beforeLoginPanel = new javax.swing.JPanel();
        buttonLogin = new javax.swing.JButton();
        buttonRegister = new javax.swing.JButton();
        questionLoginPanel = new javax.swing.JPanel();
        nickLabel = new javax.swing.JLabel();
        nickField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        buttonOk = new javax.swing.JButton();
        statementLabel = new javax.swing.JLabel();
        afterLoginPanel = new javax.swing.JPanel();
        buttonLogout = new javax.swing.JButton();
        buttonPlaySettings = new javax.swing.JButton();
        buttonGameList = new javax.swing.JButton();
        displayPanel = new javax.swing.JPanel();
        emptyPanel = new javax.swing.JPanel();
        gameListPanel = new javax.swing.JPanel();
        textFieldIdGame = new javax.swing.JTextField();
        buttonJoin = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaGameList = new javax.swing.JTextArea();
        gamePanel = new javax.swing.JPanel();
        buttonsPanel = new javax.swing.JPanel();
        timePanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        aginPanel = new javax.swing.JPanel();
        buttonAgin = new javax.swing.JButton();
        setGamePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        rbAI = new javax.swing.JRadioButton();
        rbPerson = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        rbO = new javax.swing.JRadioButton();
        rbX = new javax.swing.JRadioButton();
        buttonBackSetGame = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        textFieldBoardSizeX = new javax.swing.JTextField();
        textFieldBoardSizeY = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textFieldNumberSigns = new javax.swing.JTextField();
        buttonPlay = new javax.swing.JButton();
        searchPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(700, 700));
        setPreferredSize(new java.awt.Dimension(700, 700));

        mainPanel.setLayout(new java.awt.BorderLayout());

        menuPanel.setLayout(new java.awt.CardLayout());

        buttonLogin.setText("Zaloguj");
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });
        beforeLoginPanel.add(buttonLogin);

        buttonRegister.setText("Zarejestruj");
        beforeLoginPanel.add(buttonRegister);

        menuPanel.add(beforeLoginPanel, "beforeLoginCard");

        nickLabel.setText(" Nick");

        nickField.setText("aa");
        nickField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nickFieldActionPerformed(evt);
            }
        });

        passwordLabel.setText("  Hasło");

        passwordField.setText("qq");
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        buttonOk.setText("ok");
        buttonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout questionLoginPanelLayout = new javax.swing.GroupLayout(questionLoginPanel);
        questionLoginPanel.setLayout(questionLoginPanelLayout);
        questionLoginPanelLayout.setHorizontalGroup(
                questionLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(questionLoginPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(nickLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nickField, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(passwordLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonOk)
                                .addContainerGap())
        );
        questionLoginPanelLayout.setVerticalGroup(
                questionLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(questionLoginPanelLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(questionLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(nickField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nickLabel)
                                        .addComponent(passwordLabel)
                                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonOk))
                                .addGap(5, 5, 5))
        );

        menuPanel.add(questionLoginPanel, "questionLoginCard");

        buttonLogout.setText("Wyloguj");
        buttonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogoutActionPerformed(evt);
            }
        });
        afterLoginPanel.add(buttonLogout);

        buttonPlaySettings.setText("Stwórz gre");
        buttonPlaySettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPlaySettingsActionPerformed(evt);
            }
        });
        afterLoginPanel.add(buttonPlaySettings);

        buttonGameList.setText("Lista gier");
        buttonGameList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGameListActionPerformed(evt);
            }
        });
        afterLoginPanel.add(buttonGameList);

        menuPanel.add(afterLoginPanel, "afterLoginCard");

        mainPanel.add(menuPanel, java.awt.BorderLayout.PAGE_START);

        displayPanel.setBackground(new java.awt.Color(255, 255, 255));
        displayPanel.setLayout(new java.awt.CardLayout());
        displayPanel.add(emptyPanel, "emptyCard");

        textFieldIdGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldIdGameActionPerformed(evt);
            }
        });

        buttonJoin.setText("Dołacz");
        buttonJoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonJoinActionPerformed(evt);
            }
        });

        jLabel8.setText("Wpisz id gry");

        textAreaGameList.setColumns(20);
        textAreaGameList.setRows(5);
        jScrollPane1.setViewportView(textAreaGameList);

        javax.swing.GroupLayout gameListPanelLayout = new javax.swing.GroupLayout(gameListPanel);
        gameListPanel.setLayout(gameListPanelLayout);
        gameListPanelLayout.setHorizontalGroup(
                gameListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(gameListPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gameListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(gameListPanelLayout.createSequentialGroup()
                                                .addComponent(jScrollPane1)
                                                .addContainerGap())
                                        .addGroup(gameListPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(18, 18, 18)
                                                .addComponent(textFieldIdGame, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                                .addComponent(buttonJoin)
                                                .addGap(146, 146, 146))))
        );
        gameListPanelLayout.setVerticalGroup(
                gameListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(gameListPanelLayout.createSequentialGroup()
                                .addGroup(gameListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttonJoin)
                                        .addComponent(textFieldIdGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                .addContainerGap())
        );

        displayPanel.add(gameListPanel, "gameListCard");

        gamePanel.setLayout(new java.awt.BorderLayout());

        buttonsPanel.setLayout(new java.awt.GridLayout(1, 0));
        gamePanel.add(buttonsPanel, java.awt.BorderLayout.CENTER);

        jLabel6.setText("czas....                ");
        timePanel.add(jLabel6);

        gamePanel.add(timePanel, java.awt.BorderLayout.WEST);

        buttonAgin.setText("Jeszcze raz");
        buttonAgin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAginActionPerformed(evt);
            }
        });
        aginPanel.add(buttonAgin);

        gamePanel.add(aginPanel, java.awt.BorderLayout.EAST);

        displayPanel.add(gamePanel, "gameCard");

        jLabel2.setText("Z kim gra");

        buttonGroupAiOrPerson.add(rbAI);
        rbAI.setSelected(true);
        rbAI.setText("Sztuczna inteligencja");
        rbAI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAIActionPerformed(evt);
            }
        });

        buttonGroupAiOrPerson.add(rbPerson);
        rbPerson.setText("Człowiek");
        rbPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPersonActionPerformed(evt);
            }
        });

        jLabel1.setText("Chcesz mieć x czy o");

        buttonGroupOorX.add(rbO);
        rbO.setSelected(true);
        rbO.setText("o");
        rbO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbOActionPerformed(evt);
            }
        });

        buttonGroupOorX.add(rbX);
        rbX.setText("x");
        rbX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbXActionPerformed(evt);
            }
        });

        buttonBackSetGame.setText("Cofnij");
        buttonBackSetGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackSetGameActionPerformed(evt);
            }
        });

        jLabel3.setText("Rozmiar planszy (x na y):");

        textFieldBoardSizeX.setText("3");
        textFieldBoardSizeX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldBoardSizeXActionPerformed(evt);
            }
        });

        textFieldBoardSizeY.setText("3");

        jLabel4.setText("na");

        jLabel5.setText("Ile takich samych znaków w linii to wygrana");

        textFieldNumberSigns.setText("3");

        buttonPlay.setText("Graj");
        buttonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPlayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout setGamePanelLayout = new javax.swing.GroupLayout(setGamePanel);
        setGamePanel.setLayout(setGamePanelLayout);
        setGamePanelLayout.setHorizontalGroup(
                setGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(setGamePanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(setGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(setGamePanelLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(buttonBackSetGame)
                                                .addGap(53, 53, 53)
                                                .addComponent(buttonPlay)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(setGamePanelLayout.createSequentialGroup()
                                                .addGroup(setGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(setGamePanelLayout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(rbAI)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(rbPerson))
                                                        .addGroup(setGamePanelLayout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(rbO))
                                                        .addGroup(setGamePanelLayout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(textFieldBoardSizeX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel4)
                                                                .addGroup(setGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(setGamePanelLayout.createSequentialGroup()
                                                                                .addGap(26, 26, 26)
                                                                                .addComponent(rbX))
                                                                        .addGroup(setGamePanelLayout.createSequentialGroup()
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(textFieldBoardSizeY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addGroup(setGamePanelLayout.createSequentialGroup()
                                                                .addComponent(jLabel5)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(textFieldNumberSigns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap(399, Short.MAX_VALUE))))
        );
        setGamePanelLayout.setVerticalGroup(
                setGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(setGamePanelLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(setGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rbAI)
                                        .addComponent(jLabel2)
                                        .addComponent(rbPerson))
                                .addGap(6, 6, 6)
                                .addGroup(setGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(setGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel1)
                                                .addComponent(rbO))
                                        .addComponent(rbX))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(setGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(textFieldBoardSizeX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)
                                        .addComponent(textFieldBoardSizeY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(setGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(textFieldNumberSigns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(setGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttonBackSetGame)
                                        .addComponent(buttonPlay))
                                .addContainerGap(528, Short.MAX_VALUE))
        );

        displayPanel.add(setGamePanel, "setGameCard");

        jLabel7.setText("szukanie przeciwnika");
        searchPanel.add(jLabel7);
        searchPanel.add(progressBar);

        displayPanel.add(searchPanel, "searchCard");

        mainPanel.add(displayPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
        // TODO add your handling code here:

        ((CardLayout)this.menuPanel.getLayout()).show(menuPanel, "questionLoginCard");
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void nickFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nickFieldActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_nickFieldActionPerformed

    private void buttonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOkActionPerformed
        // TODO add your handling code here:
        password=String.copyValueOf(passwordField.getPassword());
        nick=nickField.getText();
        controller.login(nick, password);
        ((CardLayout)this.menuPanel.getLayout()).show(menuPanel, "afterLoginCard");

    }//GEN-LAST:event_buttonOkActionPerformed

    private void buttonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogoutActionPerformed
        // TODO add your handling code here:
        ((CardLayout)this.menuPanel.getLayout()).show(menuPanel, "beforeLoginCard");
    }//GEN-LAST:event_buttonLogoutActionPerformed

    private void buttonPlaySettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPlaySettingsActionPerformed
        // TODO add your handling code here:
        ((CardLayout)this.displayPanel.getLayout()).show(displayPanel, "setGameCard");
    }//GEN-LAST:event_buttonPlaySettingsActionPerformed

    private void textFieldBoardSizeXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldBoardSizeXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldBoardSizeXActionPerformed

    private void buttonBackSetGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackSetGameActionPerformed
        // TODO add your handling code here:
        ((CardLayout)this.displayPanel.getLayout()).show(displayPanel, "emptyCard");
    }//GEN-LAST:event_buttonBackSetGameActionPerformed

    private void buttonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPlayActionPerformed
        // TODO add your handling code here:

        creator=true;
        x=Integer.parseInt(textFieldBoardSizeX.getText());
        y=Integer.parseInt(textFieldBoardSizeY.getText());
        z=Integer.parseInt(textFieldNumberSigns.getText());
        controller.createGame(x, y, z,opponentType);
        System.out.println(x+" "+y+" "+opponentType);
        if(!opponentType)
        {
            createBoard();
        }
        else
        {
            ((CardLayout)this.displayPanel.getLayout()).show(displayPanel, "searchCard");

            this.searchTask = new SearchProgress();
            this.searchTask.execute();




        }


    }//GEN-LAST:event_buttonPlayActionPerformed

    private void mainActionPerformed(java.awt.event.ActionEvent evt) throws InterruptedException {


        // System.out.println(coordinate[0]+" "+coordinate[1]);
        Object z = evt.getSource();
        numberMove++;
        // if(creator)
        {
            for(int i=0;i<x && end==false;i++)
            {
                for(int j=0;j<y && end==false;j++)
                {
                    if (z==buttons[i][j] && buttons[i][j].getText()==" ")
                    {
                        //System.out.println(opponentType);
                        buttons[i][j].setText(mySign);

                        controller.saveMove(i,j,mySign);
                        boolean d=false;

                        while(!d)
                        {
                            Thread.sleep(1000);
                            d=controller.waitForMove();

                            System.out.println("czeka na ruch ");
                        }

//                          this.moveTask = new MoveProgress(i,j);
//                          this.moveTask.execute();
                        controller.getMoveMaxId();
                        coordinate=controller.getCoordinate();

                        System.out.println("jest ruch  ");
                        buttons[coordinate[0]][coordinate[1]].setText(opponentSign);
                    }

                }
            }
            // }
//        else
//        {
//
//
//           for(int i=0;i<x && end==false;i++)
//	        {
//		for(int j=0;j<y && end==false;j++)
//		{
//                    if (z==buttons[i][j] && buttons[i][j].getText()==" ")
//                    {
//		        buttons[i][j].setText(mySign);
//                        controller.saveMove(i,j,mySign);
//
//                    }
//                }
//                }
        }
//
//                    // gamelogic.waitForMove();
////			if(isWinner(znak))
//                         //end=true;
//
//

    }
    private void rbOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbOActionPerformed
        // TODO add your handling code here:
        mySign="o";
        opponentSign="x";
    }//GEN-LAST:event_rbOActionPerformed

    private void rbXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbXActionPerformed
        // TODO add your handling code here:
        mySign="x";
        opponentSign="o";
    }//GEN-LAST:event_rbXActionPerformed

    private void rbPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPersonActionPerformed
        // TODO add your handling code here:
        opponentType=true;
    }//GEN-LAST:event_rbPersonActionPerformed

    private void rbAIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAIActionPerformed
        // TODO add your handling code here:
        opponentType=false;
    }//GEN-LAST:event_rbAIActionPerformed

    private void buttonGameListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGameListActionPerformed
        // TODO add your handling code here:
        textAreaGameList.setText(controller.gameList());
        ((CardLayout)this.displayPanel.getLayout()).show(displayPanel, "gameListCard");
    }//GEN-LAST:event_buttonGameListActionPerformed


    private void buttonJoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonJoinActionPerformed

        // TODO add your handling code here:
        idGame=Integer.parseInt(textFieldIdGame.getText());
        controller.joinGame(idGame);

        System.out.print(idGame);
        x=controller.getX();
        y=controller.getY();
        z=controller.getZ();
        opponentType=true;
        creator=false;

        createBoard();
        controller.setMove();
        boolean d=false;

        while(!d)
        {
            try {
                Thread.sleep(1000);
                d=controller.waitForMove();
            } catch (InterruptedException ex) {
                Logger.getLogger(MyApplet.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("czeka na ruch myaplet ");
        }

//            if(controller.getLastSign()=="x")
//            { mySign="o";opponentSign="x";}
//            if(controller.getLastSign()=="o")
//            { mySign="x";opponentSign="o";}
        mySign="o";
        opponentSign="x";
        System.out.println(mySign);

        coordinate=controller.getCoordinate();

        System.out.println("jest ruch kurwa aplet");
        System.out.println(opponentSign);
        buttons[coordinate[0]][coordinate[1]].setText(opponentSign);


    }//GEN-LAST:event_buttonJoinActionPerformed

    private void textFieldIdGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldIdGameActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_textFieldIdGameActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:

        controller.setMove();
        boolean d=false;

        while(!d)
        {
            try {
                Thread.sleep(1000);
                d=controller.waitForMove();
            } catch (InterruptedException ex) {
                Logger.getLogger(MyApplet.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("czeka na ruch myaplet ");
        }

        if(controller.getLastSign()=="x")
        { mySign="o";opponentSign="x";}
        if(controller.getLastSign()=="o")
        { mySign="x";opponentSign="o";}

        System.out.println(mySign);

        coordinate=controller.getCoordinate();

        System.out.println("jest ruch kurwa aplet");
        buttons[coordinate[0]][coordinate[1]].setText(opponentSign);

    }//GEN-LAST:event_passwordFieldActionPerformed

    private void buttonAginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAginActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_buttonAginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel afterLoginPanel;
    private javax.swing.JPanel aginPanel;
    private javax.swing.JPanel beforeLoginPanel;
    private javax.swing.JButton buttonAgin;
    private javax.swing.JButton buttonBackSetGame;
    private javax.swing.JButton buttonGameList;
    private javax.swing.ButtonGroup buttonGroupAiOrPerson;
    private javax.swing.ButtonGroup buttonGroupOorX;
    private javax.swing.JButton buttonJoin;
    private javax.swing.JButton buttonLogin;
    private javax.swing.JButton buttonLogout;
    private javax.swing.JButton buttonOk;
    private javax.swing.JButton buttonPlay;
    private javax.swing.JButton buttonPlaySettings;
    private javax.swing.JButton buttonRegister;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JPanel displayPanel;
    private javax.swing.JPanel emptyPanel;
    private javax.swing.JPanel gameListPanel;
    private javax.swing.JPanel gamePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JTextField nickField;
    private javax.swing.JLabel nickLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JPanel questionLoginPanel;
    private javax.swing.JRadioButton rbAI;
    private javax.swing.JRadioButton rbO;
    private javax.swing.JRadioButton rbPerson;
    private javax.swing.JRadioButton rbX;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JPanel setGamePanel;
    private javax.swing.JLabel statementLabel;
    private javax.swing.JTextArea textAreaGameList;
    private javax.swing.JTextField textFieldBoardSizeX;
    private javax.swing.JTextField textFieldBoardSizeY;
    private javax.swing.JTextField textFieldIdGame;
    private javax.swing.JTextField textFieldNumberSigns;
    private javax.swing.JPanel timePanel;
    // End of variables declaration//GEN-END:variables
}

