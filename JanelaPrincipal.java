
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.*;

public class JanelaPrincipal extends JFrame {

    private Jogo jogo;
    
    /**
     * Responde aos cliques realizados no tabuleiro.
     * 
     * @param casaClicada Casa que o jogador clicou.
     */
    public void reagir(CasaGUI casaClicada) {
        if (casaClicada.possuiPeca()) {
            jogo.mostrarPeca(casaClicada.getPosicaoX(), casaClicada.getPosicaoY());
            atualizar();
            lbl_a.setText(jogo.pontos + " pontos");
            lbl_b.setText(jogo.quantidadeDeRecompensas + " recompensas");
            switch(jogo.getEstado())
            {
                case 0:
                    break;
                case 1:
                    JOptionPane.showMessageDialog(this, "Parabéns, você venceu com " + jogo.pontos + " pontos");
                    criarNovoJogo();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(this, "Você clicou em uma bomba e perdeu! Conseguiu " + jogo.pontos + " pontos");
                    criarNovoJogo();
                    break;
            }
        }
        else {
            // clicou em uma posi�?o inv�lida, ent?o n?o faz nada.
            JOptionPane.showMessageDialog(this, "Clique em uma peça.");
        }
    }
    

    /**
     * Construtor da classe.
     */
    public JanelaPrincipal() {
        initComponents();

        criarNovoJogo();

        lbl_c.setText(jogo.quantidadeDeBombas + " bombas");

        // configura action listener para o menu novo
        menuNovo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                criarNovoJogo();
            }
        });

        // configura action listener para o menu sair
        menuSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        super.setLocationRelativeTo(null);
        super.setVisible(true);
        super.pack();
    }

    

    /**
     * Cria um novo jogo e atualiza o tabuleiro gr�fico.
     */
    private void criarNovoJogo() {   
        jogo = new Jogo();
        lbl_a.setText(jogo.pontos + " pontos");
        lbl_b.setText(jogo.quantidadeDeRecompensas + " recompensas");
        atualizar();
        timer.start();
    }

    ActionListener al=new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            jogo.esconderElementos();
            atualizar();
            timer.stop();
        }
    };

    Timer timer = new Timer(1000, al);

    private void atualizar() {
        tabuleiroGUI.atualizar(jogo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLinhas = new javax.swing.JPanel();
        pnlColunas = new javax.swing.JPanel();
        lbl_a = new javax.swing.JLabel();
        lbl_b = new javax.swing.JLabel();
        lbl_c = new javax.swing.JLabel();
        tabuleiroGUI = new TabuleiroGUI(this);
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        menuNovo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlLinhas.setLayout(new java.awt.GridLayout(8, 1));


        pnlColunas.setLayout(new java.awt.GridLayout(1, 8));

        lbl_a.setFont(new java.awt.Font("Arimo", 0, 18)); // NOI18N
        lbl_a.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_a.setText(0 + " pontos");
        pnlColunas.add(lbl_a);

        lbl_b.setFont(new java.awt.Font("Arimo", 0, 18)); // NOI18N
        lbl_b.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_b.setText(0 + " recompensas");
        pnlColunas.add(lbl_b);

        lbl_c.setFont(new java.awt.Font("Arimo", 0, 18)); // NOI18N
        lbl_c.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_c.setText(0 + " bombas");
        pnlColunas.add(lbl_c);

        menuArquivo.setText("Jogo");

        menuNovo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuNovo.setText("Novo");
        menuArquivo.add(menuNovo);
        menuArquivo.add(jSeparator1);

        menuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuSair.setText("Sair");
        menuArquivo.add(menuSair);

        jMenuBar1.add(menuArquivo);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlLinhas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlColunas, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addComponent(tabuleiroGUI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlLinhas, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tabuleiroGUI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlColunas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lbl_a;
    private javax.swing.JLabel lbl_b;
    private javax.swing.JLabel lbl_c;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenuItem menuNovo;
    private javax.swing.JMenuItem menuSair;
    private javax.swing.JPanel pnlColunas;
    private javax.swing.JPanel pnlLinhas;
    private TabuleiroGUI tabuleiroGUI;
    // End of variables declaration//GEN-END:variables

}
