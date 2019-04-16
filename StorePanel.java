package lemonadeStand;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Font;

@SuppressWarnings("serial")
public class StorePanel extends JPanel {

	private int money;
	private int helpRate;
	private int purchasePrice = 3;
	private int upgradeTreePrice = 10;
	private int upgradeUmbrellaPrice = 10;
	private int levelTrees = 0;
	private int levelUmbrellas = 0;
	private Icon picTree = new ImageIcon(DemoLemonadeStand.class.getResource("/lemonadeStand/Images/Tree.png"));
	private Icon picUmbrella = new ImageIcon(
			DemoLemonadeStand.class.getResource("/lemonadeStand/Images/Big Umbrella.png"));
	private JButton btnUpgradeTree;
	private JButton btnUpgradeUmbrella;
	private JLabel lblLevel;
	private static int treeCap;

	/**
	 * Create the panel.
	 * 
	 * @return
	 */
	public StorePanel() {
		setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setLayout(new BorderLayout(0, 0));

		JPanel purchaseViewPanel = createPurchaseViewPanel();
		add(purchaseViewPanel, BorderLayout.WEST);

		JPanel exitPanel = createExitPanel();
		add(exitPanel, BorderLayout.SOUTH);

		JPanel mainPanel = createMainPanel();
		add(mainPanel, BorderLayout.CENTER);

	}

	private JPanel createPurchaseViewPanel() {
		JPanel purchaseViewPanel = new JPanel();
		purchaseViewPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel itemsPanelUmbrella = createItemsPanelUmbrella();
		purchaseViewPanel.add(itemsPanelUmbrella);

		JPanel itemsPanelTree = createItemsPanelTree();
		purchaseViewPanel.add(itemsPanelTree);

		return purchaseViewPanel;
	}

	private JPanel createItemsPanelUmbrella() {
		JPanel itemsPanelUmbrella = new JPanel();
		itemsPanelUmbrella.setBorder(new LineBorder(new Color(0, 0, 0)));
		itemsPanelUmbrella.setLayout(new BorderLayout(0, 0));

		JLabel lblPurchasePicUmbrella = new JLabel();
		lblPurchasePicUmbrella.setIcon(picUmbrella);
		itemsPanelUmbrella.add(lblPurchasePicUmbrella);

		JButton btnPurchaseUmbrella = createBtnPurchaseUmbrella();
		itemsPanelUmbrella.add(btnPurchaseUmbrella, BorderLayout.SOUTH);
		return itemsPanelUmbrella;
	}

	private JPanel createItemsPanelTree() {
		JPanel itemsPanelTree = new JPanel();
		itemsPanelTree.setBorder(new LineBorder(new Color(0, 0, 0)));
		itemsPanelTree.setLayout(new BorderLayout(0, 0));

		JLabel lblPurchasePicTree = new JLabel();
		lblPurchasePicTree.setIcon(picTree);
		itemsPanelTree.add(lblPurchasePicTree);

		JButton btnPurchaseTree = createBtnPurchaseTree();
		itemsPanelTree.add(btnPurchaseTree, BorderLayout.SOUTH);

		return itemsPanelTree;
	}

	private JButton createBtnPurchaseTree() {
		JButton btnPurchaseTree = new JButton("Purchase for $3");
		btnPurchaseTree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (changeMoney(purchasePrice, "Purchase a Tree")) {
					btnUpgradeTree.setEnabled(true);
					btnPurchaseTree.setEnabled(false);
				}
			}
		});
		return btnPurchaseTree;
	}

	private JButton createBtnPurchaseUmbrella() {
		JButton btnPurchaseUmbrella = new JButton("Purchase for $3");
		btnPurchaseUmbrella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (changeMoney(purchasePrice, "Purchase an Umbrella")) {
					btnUpgradeUmbrella.setEnabled(true);
					btnPurchaseUmbrella.setEnabled(false);
				}
			}
		});
		return btnPurchaseUmbrella;
	}

	private JPanel createMainPanel() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel boughtPanelUmbrella = createBoughtPanelUmbrella();
		mainPanel.add(boughtPanelUmbrella);

		JPanel boughtPanelTree = createBoughtPanelTree();
		mainPanel.add(boughtPanelTree);

		return mainPanel;
	}

	private JPanel createBoughtPanelUmbrella() {
		JPanel boughtPanel = new JPanel();
		boughtPanel.setBackground(new Color(204, 153, 51));
		boughtPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		boughtPanel.setLayout(new BorderLayout(0, 0));

		JLabel[] lblLvlUmbrellas = new JLabel[5];
		lblLvlUmbrellas[0] = createLblLvl(1);
		lblLvlUmbrellas[1] = createLblLvl(2);
		lblLvlUmbrellas[2] = createLblLvl(3);
		lblLvlUmbrellas[3] = createLblLvl(4);
		lblLvlUmbrellas[4] = createLblLvl(5);

		JPanel umbrellaLevelPanel = createUmbrellaLevelPanel(lblLvlUmbrellas);
		boughtPanel.add(umbrellaLevelPanel, BorderLayout.NORTH);

		JPanel pnltxtUpgadeUmbrella = createPnlTxtUpgradeUmbrella();
		boughtPanel.add(pnltxtUpgadeUmbrella, BorderLayout.CENTER);

		JLabel lblDisplayPrice = new JLabel("10");
		lblDisplayPrice.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDisplayPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisplayPrice.setFont(new Font("Microsoft Tai Le", Font.BOLD, 28));
		pnltxtUpgadeUmbrella.add(lblDisplayPrice);

		createUpgradeUmbrella(lblLvlUmbrellas, lblDisplayPrice);
		return boughtPanel;
	}
//  TODO
	private void createUpgradeUmbrella(JLabel[] lblLvlUmbrellas, JLabel lblDisplayPrice) {
		btnUpgradeUmbrella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (changeMoney(upgradeUmbrellaPrice, "Upgrade your Umbrella")) {
					lblLvlUmbrellas[levelUmbrellas].setBackground(Color.GRAY);
					levelUmbrellas++;
					StormBullyLotto.setUmbrellaHelpRate(getLevelUmbrellas());
					if (levelUmbrellas >= 5)
						btnUpgradeUmbrella.setEnabled(false);
					upgradeUmbrellaPrice *= 2;
					lblDisplayPrice.setText("" + upgradeUmbrellaPrice);
				}
			}
		});
	}

	private JPanel createPnlTxtUpgradeUmbrella() {
		JPanel pnltxtUpgadeUmbrella = new JPanel();
		pnltxtUpgadeUmbrella.setOpaque(false);

		JLabel label = new JLabel("Upgrade for $");
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Sylfaen", Font.BOLD, 20));
		pnltxtUpgadeUmbrella.add(label);
		
		lblLevel = new JLabel("level");
		pnltxtUpgadeUmbrella.add(lblLevel);

		return pnltxtUpgadeUmbrella;
	}

	private JPanel createUmbrellaLevelPanel(JLabel[] lblLvlUmbrellas) {
		JPanel umbrellaLevelPanel = new JPanel();
		umbrellaLevelPanel.setOpaque(false);

		JLabel lblBoughticon = new JLabel("boughtIcon");
		umbrellaLevelPanel.add(lblBoughticon);

		JPanel lvlPanel = new JPanel();
		lvlPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lvlPanel.add(lblLvlUmbrellas[0]);
		lvlPanel.add(lblLvlUmbrellas[1]);
		lvlPanel.add(lblLvlUmbrellas[2]);
		lvlPanel.add(lblLvlUmbrellas[3]);
		lvlPanel.add(lblLvlUmbrellas[4]);
		umbrellaLevelPanel.add(lvlPanel);

		btnUpgradeUmbrella = new JButton("Upgrade");
		btnUpgradeUmbrella.setEnabled(false);
		umbrellaLevelPanel.add(btnUpgradeUmbrella);
		return umbrellaLevelPanel;
	}

	private JPanel createBoughtPanelTree() {
		JPanel boughtPanel = new JPanel();
		boughtPanel.setBackground(new Color(204, 153, 51));
		boughtPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		boughtPanel.setLayout(new BorderLayout(0, 0));

		JLabel[] lblLvlTrees = new JLabel[5];
		lblLvlTrees[0] = createLblLvl(1);
		lblLvlTrees[1] = createLblLvl(2);
		lblLvlTrees[2] = createLblLvl(3);
		lblLvlTrees[3] = createLblLvl(4);
		lblLvlTrees[4] = createLblLvl(5);

		JPanel treeLevelPanel = createTreeLevelPanel(lblLvlTrees);
		boughtPanel.add(treeLevelPanel, BorderLayout.NORTH);

		JPanel pnltxtUpgadeTree = new JPanel();
		pnltxtUpgadeTree.setOpaque(false);

		JLabel lblUpgradefor = new JLabel("Upgrade for $");
		lblUpgradefor.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUpgradefor.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpgradefor.setFont(new Font("Sylfaen", Font.BOLD, 20));
		pnltxtUpgadeTree.add(lblUpgradefor);

		JLabel lblDisplayPrice = new JLabel("10");
		lblDisplayPrice.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDisplayPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisplayPrice.setFont(new Font("Microsoft Tai Le", Font.BOLD, 28));
		pnltxtUpgadeTree.add(lblDisplayPrice);

		boughtPanel.add(pnltxtUpgadeTree, BorderLayout.CENTER);

		createBtnUpgrade(lblLvlTrees, lblDisplayPrice);
		
		JLabel lblLevel_1 = new JLabel("level");
		pnltxtUpgadeTree.add(lblLevel_1);

		return boughtPanel;
	}
// TODO
	private void createBtnUpgrade(JLabel[] lblLvlTrees, JLabel lblDisplayPrice) {
		btnUpgradeTree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (changeMoney(upgradeTreePrice, "Upgrade your Tree")) {
					lblLvlTrees[levelTrees].setBackground(Color.GRAY);
					levelTrees++;
					setTreeCap(levelTrees);
					lblLevel.setText(String.valueOf(getTreeCap()));

					if (levelTrees >= 5)
						btnUpgradeTree.setEnabled(false);
					upgradeTreePrice *= 2;
					lblDisplayPrice.setText("" + upgradeTreePrice);
				}
			}
		});
	}

	private JPanel createTreeLevelPanel(JLabel[] lblLvlTrees) {
		JPanel treeLevelPanel = new JPanel();
		treeLevelPanel.setOpaque(false);

		JLabel lblBoughticon = new JLabel("boughtIcon");
		treeLevelPanel.add(lblBoughticon);

		JPanel lvlBoxPanel = new JPanel();
		lvlBoxPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lvlBoxPanel.add(lblLvlTrees[0]);
		lvlBoxPanel.add(lblLvlTrees[1]);
		lvlBoxPanel.add(lblLvlTrees[2]);
		lvlBoxPanel.add(lblLvlTrees[3]);
		lvlBoxPanel.add(lblLvlTrees[4]);
		treeLevelPanel.add(lvlBoxPanel);

		btnUpgradeTree = new JButton("Upgrade");
		btnUpgradeTree.setEnabled(false);
		treeLevelPanel.add(btnUpgradeTree);
		return treeLevelPanel;
	}

//	private JPanel createLvlPanel() {
//		JPanel lvlPanel = new JPanel();
//		lblLvlTrees = new JLabel[5]; 
//		lvlPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		
//		lblLvlTrees[0]= createLblLvl(1);
//		lvlPanel.add(lblLvlTrees[0]);
//		
//		lblLvlTrees[1]= createLblLvl(2);
//		lvlPanel.add(lblLvlTrees[1]);
//		
//		lblLvlTrees[2]= createLblLvl(3);
//		lvlPanel.add(lblLvlTrees[2]);
//		
//		lblLvlTrees[3]= createLblLvl(4);
//		lvlPanel.add(lblLvlTrees[3]);
//		
//		lblLvlTrees[4]= createLblLvl(5);
//		lvlPanel.add(lblLvlTrees[4]);
//		
//		return lvlPanel;
//	}

	private JLabel createLblLvl(int level) {
		JLabel lblLvl = new JLabel();
		lblLvl.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLvl.setHorizontalAlignment(SwingConstants.CENTER);
		lblLvl.setPreferredSize(new Dimension(30, 45));

		lblLvl.setText("" + level);
		lblLvl.setOpaque(true);
		lblLvl.setBackground(Color.LIGHT_GRAY);
		lblLvl.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		return lblLvl;
	}

	private JPanel createExitPanel() {
		JPanel exitPanel = new JPanel();
		exitPanel.setBackground(new Color(153, 102, 0));
		exitPanel.setLayout(new BorderLayout(0, 0));

		JButton btnExit = createBtnExit();
		exitPanel.add(btnExit, BorderLayout.EAST);

		return exitPanel;
	}

	private JButton createBtnExit() {
		JButton btnExit = new JButton("Exit");
		btnExit.setBorder(new EmptyBorder(5, 40, 5, 40));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DemoLemonadeStand.parentPanel.removeAll();
				DemoLemonadeStand.parentPanel.add(DemoLemonadeStand.imagePanel);
				DemoLemonadeStand.parentPanel.repaint();
				DemoLemonadeStand.parentPanel.revalidate();
			}
		});
		return btnExit;
	}

	private boolean changeMoney(int price, String type) {
		money = DemoLemonadeStand.getMoney();
//		StormBullyLotto.setTreeHelpRate(levelTrees);

		if (price > money) {
			DemoLemonadeStand.txtrOutputTextPanel.setText("You do not have enough money to " + type + "!");
			Music.notEnoughMoney();
			return false;
		} else {
			DemoLemonadeStand.setMoney((money -= price));
			return true;
		}
	}

	public int update(int helpRate) {
		this.helpRate = helpRate;
		return helpRate;
	}
	
	private void setTreeCap(int levelTrees) {
		switch (levelTrees) {
		case 1:
			treeCap = 3;
			break;
		case 2:
			treeCap = 5;
			break;
		case 3:
			treeCap = 8;
			break;
		case 4:
			treeCap = 12;
			break;
		case 5:
			treeCap = 15;
			break;
		default:
			treeCap = 1;
		}
	}

	public static int getTreeCap() {
		return treeCap;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getHelpRate() {
		return helpRate;
	}

	public void setHelpRate(int helpRate) {
		this.helpRate = helpRate;
	}

	public int getLevelTrees() {
		return levelTrees;
	}

	public void setLevelTrees(int levelTrees) {
		this.levelTrees = levelTrees;
	}

	public int getLevelUmbrellas() {
		return levelUmbrellas;
	}

	public void setLevelUmbrellas(int levelUmbrellas) {
		this.levelUmbrellas = levelUmbrellas;
	}

}
