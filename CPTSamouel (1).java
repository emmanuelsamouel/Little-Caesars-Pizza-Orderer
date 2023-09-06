import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.*;

public class CPTSamouel implements ActionListener, WindowListener {
	//declaring attributes: buttons, labels, check boxes, combo box, text area, frame, font, integers, doubles, number format, button group. Declaring and initializing constants and array
	private static final double DRINK_COST = 0.99, SMALL = 7.99, MEDIUM = 8.99, LARGE = 9.99, PARTY = 10.99, HST = 0.13;
	private JRadioButton rbSmall, rbMedium, rbLarge, rbParty;
	private JCheckBox chkMushrooms, chkGreenPeppers, chkOnions, chkHotPeppers, chkPepperoni, chkBacon, chkTomatoes, chkExtraCheese;
	private JLabel lblSizeCost, lblToppingsCost, lblDrinkCost, lblSubtotalCost, lblDeliveryFeeFree, lblHSTCost,
			lblGrandTotalCost, lblSubtotal, lblDeliveryFee, lblHST, lblGrandTotal, lblCoke, lblSprite, lblOrange,
			lblRootBeer, lblLittleCaesarLogo, lblPayment, lblCoupon;
	private static int toppingsCounter = 0;
	private static int checkOutOption, exitOption, couponOption;
	private NumberFormat currency;
	private double toppingsCost = 0, drinksCost = 0, pizzaSize = 0, hst, taxes;
	private Integer[] num1 = { 0, 1, 2, 3, 4, 5, 6 };
	private JComboBox<Integer> cbo1, cbo2, cbo3, cbo4;
	private JButton btnCalculate, btnClear, btnCheckout, btnExit;
	private ButtonGroup bgSize;
	private JTextArea myArea;
	public static JFrame frame;
	private Font coupon;
	
	//initializing buttons, labels, check boxes, combo box, text area, frame, font, number format, button group in the constructor
	public CPTSamouel() {
	coupon = new Font("Ariel", Font.BOLD, 40);
		frame = new JFrame("Little Caesar's - Hot 'N Ready!");
		frame.addWindowListener(this);
		
		
       
		currency = NumberFormat.getCurrencyInstance(Locale.CANADA);

		rbSmall = new JRadioButton("Small");
		rbSmall.addActionListener(this);
		rbSmall.setBackground(Color.WHITE);

		rbMedium = new JRadioButton("Medium");
		rbMedium.addActionListener(this);
		rbMedium.setBackground(Color.WHITE);

		rbLarge = new JRadioButton("Large");
		rbLarge.addActionListener(this);
		rbLarge.setBackground(Color.WHITE);

		rbParty = new JRadioButton("Party");
		rbParty.addActionListener(this);
		rbParty.setBackground(Color.WHITE);

		chkMushrooms = new JCheckBox("Mushrooms");
		chkMushrooms.addActionListener(this);
		chkMushrooms.setBackground(Color.WHITE);

		chkGreenPeppers = new JCheckBox("Green Peppers");
		chkGreenPeppers.addActionListener(this);
		chkGreenPeppers.setBackground(Color.WHITE);

		chkOnions = new JCheckBox("Onions");
		chkOnions.addActionListener(this);
		chkOnions.setBackground(Color.WHITE);

		chkHotPeppers = new JCheckBox("Hot Peppers");
		chkHotPeppers.addActionListener(this);
		chkHotPeppers.setBackground(Color.WHITE);

		chkPepperoni = new JCheckBox("Pepperoni");
		chkPepperoni.addActionListener(this);
		chkPepperoni.setBackground(Color.WHITE);

		chkBacon = new JCheckBox("Bacon");
		chkBacon.addActionListener(this);
		chkBacon.setBackground(Color.WHITE);

		chkTomatoes = new JCheckBox("Tomatoes");
		chkTomatoes.addActionListener(this);
		chkTomatoes.setBackground(Color.WHITE);

		chkExtraCheese = new JCheckBox("Extra Cheese");
		chkExtraCheese.addActionListener(this);
		chkExtraCheese.setBackground(Color.WHITE);

		bgSize = new ButtonGroup();

		bgSize.add(rbSmall);
		bgSize.add(rbMedium);
		bgSize.add(rbLarge);
		bgSize.add(rbParty);

		lblSizeCost = new JLabel("$0.00");
		lblSizeCost.setBounds(15, 340, 100, 25);
		lblSizeCost.setBorder(BorderFactory.createEtchedBorder());
		lblSizeCost.setHorizontalAlignment(JLabel.CENTER);

		lblToppingsCost = new JLabel("$0.00");
		lblToppingsCost.setBounds(225, 340, 100, 25);
		lblToppingsCost.setBorder(BorderFactory.createEtchedBorder());
		lblToppingsCost.setHorizontalAlignment(JLabel.CENTER);

		lblDrinkCost = new JLabel("$0.00");
		lblDrinkCost.setBounds(440, 340, 100, 25);
		lblDrinkCost.setBorder(BorderFactory.createEtchedBorder());
		lblDrinkCost.setHorizontalAlignment(JLabel.CENTER);

		lblSubtotalCost = new JLabel("");
		lblSubtotalCost.setBounds(280, 420, 100, 25);
		lblSubtotalCost.setBorder(BorderFactory.createEtchedBorder());
		lblSubtotalCost.setHorizontalAlignment(JLabel.CENTER);

		lblDeliveryFeeFree = new JLabel("");
		//lblDeliveryFeeFree.setOpaque(true);
		//lblDeliveryFeeFree.setBackground(Color.green);
		lblDeliveryFeeFree.setBorder(BorderFactory.createEtchedBorder());

		lblDeliveryFeeFree.setBounds(280, 453, 100, 25);

		lblDeliveryFeeFree.setHorizontalAlignment(JLabel.CENTER);

		lblHSTCost = new JLabel("");
		lblHSTCost.setBounds(280, 485, 100, 25);
		lblHSTCost.setBorder(BorderFactory.createEtchedBorder());
		lblHSTCost.setHorizontalAlignment(JLabel.CENTER);

		lblGrandTotalCost = new JLabel("");
		lblGrandTotalCost.setBounds(280, 515, 100, 25);
		lblGrandTotalCost.setBorder(BorderFactory.createEtchedBorder());
		lblGrandTotalCost.setHorizontalAlignment(JLabel.CENTER);

		lblSubtotal = new JLabel("SUBTOTAL:");
		lblSubtotal.setBounds(170, 420, 100, 25);

		lblDeliveryFee = new JLabel("DELIVERY FEE:");
		lblDeliveryFee.setBounds(170, 453, 100, 25);

		lblHST = new JLabel("HST:");
		lblHST.setBounds(170, 485, 100, 25);

		lblGrandTotal = new JLabel("GRAND TOTAL:");
		lblGrandTotal.setBounds(170, 515, 100, 25);
		
		lblCoupon = new JLabel("$5 OFF ANY SIZE PIZZA!");
		lblCoupon.setBounds(35, 100, 500, 50);
		lblCoupon.setHorizontalAlignment(JLabel.CENTER);
		lblCoupon.setFont(coupon);
		lblCoupon.setForeground(Color.red);

		btnCalculate = new JButton("CALCULATE");
		btnCalculate.setBounds(425, 400, 125, 30);
		btnCalculate.addActionListener(this);

		btnClear = new JButton("CLEAR");
		btnClear.setBounds(425, 440, 125, 30);
		btnClear.addActionListener(this);

		btnCheckout = new JButton("CHECKOUT");
		btnCheckout.setBounds(425, 480, 125, 30);
		btnCheckout.addActionListener(this);

		btnExit = new JButton("EXIT");
		btnExit.setBounds(425, 520, 125, 30);
		btnExit.addActionListener(this);

		lblCoke = new JLabel("Coke");

		// lblCoke.setBackground(Color.WHITE);

		lblSprite = new JLabel("Sprite");

		// lblSprite.setBackground(Color.WHITE);

		lblOrange = new JLabel("Orange");

		// lblOrange.setBackground(Color.WHITE);

		lblRootBeer = new JLabel("Root Beer");

		// lblRootBeer.setBackground(Color.WHITE);

		cbo1 = new JComboBox<Integer>(num1);
		cbo1.addActionListener(this);

		// Integer [] num2 = {0, 1, 2, 3, 4, 5, 6};
		cbo2 = new JComboBox<Integer>(num1);
		cbo2.addActionListener(this);

		// Integer [] num3 = {0, 1, 2, 3, 4, 5, 6};
		cbo3 = new JComboBox<Integer>(num1);
		cbo3.addActionListener(this);

		// Integer [] num4 = {0, 1, 2, 3, 4, 5, 6};
		cbo4 = new JComboBox<Integer>(num1);
		cbo4.addActionListener(this);

		lblLittleCaesarLogo = new JLabel();
		lblLittleCaesarLogo.setBounds(15, 1, 550, 100);
		lblLittleCaesarLogo.setIcon(new ImageIcon("littleclogo.png"));

		lblPayment = new JLabel();
		lblPayment.setBounds(25, 400, 80, 150);
		lblPayment.setIcon(new ImageIcon("pay.png"));

		myArea = new JTextArea();

		myArea.setText("First three (3) toppings are free!");

		myArea.setBounds(190, 310, 400, 25);

	}
//adding the components to the panel
	public void addButton(JPanel panel) {
		JPanel btnPanel = new JPanel();
		JPanel chkPanel = new JPanel();
		JPanel cboPanel = new JPanel();

		btnPanel.setBounds(5, 150, 125, 150);
		btnPanel.setBackground(Color.WHITE);
		btnPanel.setBorder(BorderFactory.createTitledBorder("SIZE"));

		chkPanel.setBounds(145, 150, 250, 150);
		chkPanel.setBackground(Color.WHITE);
		chkPanel.setBorder(BorderFactory.createTitledBorder("TOPPINGS"));

		cboPanel.setBounds(410, 150, 150, 150);
		cboPanel.setBackground(Color.WHITE);
		cboPanel.setBorder(BorderFactory.createTitledBorder("BEVERAGES"));

		btnPanel.setLayout(new GridLayout(4, 1));

		btnPanel.add(rbSmall);
		btnPanel.add(rbMedium);
		btnPanel.add(rbLarge);
		btnPanel.add(rbParty);

		chkPanel.setLayout(new GridLayout(4, 2));
		chkPanel.add(chkMushrooms);
		chkPanel.add(chkPepperoni);
		chkPanel.add(chkGreenPeppers);
		chkPanel.add(chkBacon);
		chkPanel.add(chkOnions);
		chkPanel.add(chkTomatoes);
		chkPanel.add(chkHotPeppers);
		chkPanel.add(chkExtraCheese);

		cboPanel.setLayout(new GridLayout(4, 2, 0, 5));
		cboPanel.add(lblCoke);
		cboPanel.add(cbo1);
		cboPanel.add(lblSprite);
		cboPanel.add(cbo2);
		cboPanel.add(lblOrange);
		cboPanel.add(cbo3);
		cboPanel.add(lblRootBeer);
		cboPanel.add(cbo4);

		panel.add(lblSizeCost);
		panel.add(lblToppingsCost);
		panel.add(lblDrinkCost);
		panel.add(lblSubtotalCost);
		panel.add(lblDeliveryFeeFree);
		panel.add(lblHSTCost);
		panel.add(lblGrandTotalCost);
		panel.add(lblSubtotal);
		panel.add(lblDeliveryFee);
		panel.add(lblHST);
		panel.add(lblGrandTotal);
		panel.add(lblLittleCaesarLogo);
		panel.add(lblPayment);
		panel.add(lblCoupon);
//		panel.add(lblCouponCode);
//		panel.add(lblCouponApplied);

		panel.add(btnCalculate);
		panel.add(btnClear);
		panel.add(btnCheckout);
		panel.add(btnExit);
		//panel.add(btnApplyCoupon);

		panel.add(myArea);

		//panel.add(txtCouponCode);

		panel.add(btnPanel);
		panel.add(chkPanel);
		panel.add(cboPanel);
	}
//this method will be called when an action is performed and this method changes the price on labels, clears the labels, shows the totals of a purchase and the tax and does other things as well
	public void actionPerformed(ActionEvent e) {
	

		if (e.getSource() instanceof JRadioButton) {
			if (rbSmall.isSelected()) {
				pizzaSize = SMALL;
				lblSizeCost.setText(currency.format(SMALL));
			} else if (rbMedium.isSelected()) {
				lblSizeCost.setText(currency.format(MEDIUM));
				pizzaSize = MEDIUM;
			} else if (rbLarge.isSelected()) {
				lblSizeCost.setText(currency.format(LARGE));
				pizzaSize = LARGE;
			} else {
				lblSizeCost.setText(currency.format(PARTY));
				pizzaSize = PARTY;
			}
		}
		
		else if (e.getSource() instanceof JCheckBox) {
			if (e.getSource() == chkMushrooms) {
				if (chkMushrooms.isSelected()) {
					toppingsCounter += 1;
				} else {
					toppingsCounter -= 1;
					toppingsCost -= 2;
				}
			} else if (e.getSource() == chkGreenPeppers) {
				if (chkGreenPeppers.isSelected()) {
					toppingsCounter += 1;
				} else {
					toppingsCounter -= 1;
					toppingsCost -= 2;
				}
			} else if (e.getSource() == chkOnions) {
				if (chkOnions.isSelected()) {
					toppingsCounter += 1;
				} else {
					toppingsCounter -= 1;
					toppingsCost -= 2;
				}
			} else if (e.getSource() == chkHotPeppers) {
				if (chkHotPeppers.isSelected()) {
					toppingsCounter += 1;
				} else {
					toppingsCounter -= 1;
					toppingsCost -= 2;
				}
			} else if (e.getSource() == chkPepperoni) {
				if (chkPepperoni.isSelected()) {
					toppingsCounter += 1;
				} else {
					toppingsCounter -= 1;
					toppingsCost -= 2;
				}
			} else if (e.getSource() == chkBacon) {
				if (chkBacon.isSelected()) {
					toppingsCounter += 1;
				} else {
					toppingsCounter -= 1;
					toppingsCost -= 2;
				}
			} else if (e.getSource() == chkTomatoes) {
				if (chkTomatoes.isSelected()) {
					toppingsCounter += 1;
				} else {
					toppingsCounter -= 1;
					toppingsCost -= 2;
				}
			} else {
				if (chkExtraCheese.isSelected()) {
					toppingsCounter += 1;
				} else {
					toppingsCounter -= 1;
					toppingsCost -= 2;
				}
			}

			if (toppingsCounter < 4) {
				// lblToppingsCost.setText("$0.00");
				toppingsCost = 0;
			} else {
				toppingsCost += 1.0;
			}
			lblToppingsCost.setText(currency.format(toppingsCost));
		}


		if (e.getSource() instanceof JButton) {
			if (e.getSource() == btnCalculate) {
				
				if(toppingsCost + drinksCost + pizzaSize>=15) {
					lblSubtotalCost.setText(currency.format(toppingsCost + drinksCost + pizzaSize));
					lblDeliveryFeeFree.setText("FREE");
					lblDeliveryFeeFree.setOpaque(true);
					lblDeliveryFeeFree.setBackground(Color.green);
					hst = HST * (toppingsCost + drinksCost + pizzaSize);
					lblGrandTotalCost.setText(currency.format(hst + toppingsCost + drinksCost + pizzaSize));
				}
				else {
					lblSubtotalCost.setText(currency.format(toppingsCost + drinksCost + pizzaSize));
					lblDeliveryFeeFree.setBackground(Color.white);
					hst = HST * (toppingsCost + drinksCost + pizzaSize+3);
					lblDeliveryFeeFree.setText("$3.00");
					lblGrandTotalCost.setText(currency.format(hst + toppingsCost + drinksCost + pizzaSize+3));
				}
				//hst = HST * (toppingsCost + drinksCost + pizzaSize+3);
				lblHSTCost.setText(currency.format(hst));
				//lblGrandTotalCost.setText(currency.format(hst + toppingsCost + drinksCost + pizzaSize));
			}
			if (e.getSource() == btnClear) {
				toppingsCounter = 0;
				toppingsCost = 0;
				drinksCost = 0;
					pizzaSize = 0;
				lblSizeCost.setText("$0.00");
				lblDrinkCost.setText("$0.00");
				lblToppingsCost.setText(currency.format(toppingsCounter));
				lblSubtotalCost.setText("");
				lblHSTCost.setText("");
				lblGrandTotalCost.setText("");
				lblDeliveryFeeFree.setText("");
				lblDeliveryFeeFree.setBackground(Color.white);
				bgSize.clearSelection();
				chkMushrooms.setSelected(false);
				chkGreenPeppers.setSelected(false);
				chkOnions.setSelected(false);
				chkHotPeppers.setSelected(false);
				chkPepperoni.setSelected(false);
				chkBacon.setSelected(false);
				chkTomatoes.setSelected(false);
				chkExtraCheese.setSelected(false);
				cbo1.setSelectedIndex(0);
				cbo2.setSelectedIndex(0);
				cbo3.setSelectedIndex(0);
				cbo4.setSelectedIndex(0);
				
				

			}
			if (e.getSource() == btnCheckout) {
				if (rbSmall.isSelected() || rbMedium.isSelected() || rbLarge.isSelected() || rbParty.isSelected()) {
					checkOutOption = JOptionPane.showConfirmDialog(null, "Is this order correct?", "Little Caesar's - Hot 'N Ready!",
							JOptionPane.YES_NO_OPTION);
					if (checkOutOption == 0) {
						couponOption = JOptionPane.showConfirmDialog(null, "Do you want to apply the coupon?", "Little Caesar's - Hot 'N Ready!",
								JOptionPane.YES_NO_OPTION);
						if(couponOption == 0) {
							if(toppingsCost + drinksCost + pizzaSize >= 15) {
						taxes = HST * (toppingsCost + drinksCost + pizzaSize -5);
						JOptionPane.showMessageDialog(null, "Receipt:\nFood and Beverage: " + currency.format(toppingsCost + drinksCost + pizzaSize) + "\nDelivery: $0.00\nPromotion Applied: -$5.00\nTaxes: " + currency.format(taxes) + "\nGrand Total: " + currency.format(toppingsCost + drinksCost + pizzaSize -5 + taxes), "Receipt", JOptionPane.INFORMATION_MESSAGE, null);
						}
						else {
							taxes = HST * (toppingsCost + drinksCost + pizzaSize -2);
							JOptionPane.showMessageDialog(null, "Receipt:\nFood and Beverage: " + currency.format(toppingsCost + drinksCost + pizzaSize) + "\nDelivery: $3.00\nPromotion Applied: -$5.00\nTaxes: " + currency.format(taxes) + "\nGrand Total: " + currency.format(toppingsCost + drinksCost + pizzaSize +3 -5+ taxes), "Receipt", JOptionPane.INFORMATION_MESSAGE, null);
						}
						}
						else {
							if(toppingsCost + drinksCost + pizzaSize >= 15) {
								
								taxes = HST * (toppingsCost + drinksCost + pizzaSize);
								JOptionPane.showMessageDialog(null, "Receipt:\nFood and Beverage: " + currency.format(toppingsCost + drinksCost + pizzaSize) + "\nDelivery: $0.00\nPromotion Applied: -$0.00\nTaxes: " + currency.format(taxes) + "\nGrand Total: " + currency.format(toppingsCost + drinksCost + pizzaSize + taxes), "Receipt", JOptionPane.INFORMATION_MESSAGE, null);
							}
							else {
								taxes = HST * (toppingsCost + drinksCost + pizzaSize+3);
								JOptionPane.showMessageDialog(null, "Receipt:\nFood and Beverage: " + currency.format(toppingsCost + drinksCost + pizzaSize) + "\nDelivery: $3.00\nPromotion Applied: -$0.00\nTaxes: " + currency.format(taxes) + "\nGrand Total: " + currency.format(toppingsCost + drinksCost + pizzaSize + taxes+3), "Receipt", JOptionPane.INFORMATION_MESSAGE, null);
							}
						
						}
						JOptionPane.showMessageDialog(null,
								"Thank you for ordering from Little Caesar's!\nYour pizza will be delivered in 30 minutes or it's free!",
								"Little Caesar's - Hot 'N Ready!", JOptionPane.DEFAULT_OPTION, new ImageIcon("littlecman.png"));
						System.exit(0);
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Your order could not be completed!\nPlease select a pizza size.", "Critical error!",
							JOptionPane.ERROR_MESSAGE, null);
				}

			}
			if (e.getSource() == btnExit) {
				exitOption = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Little Caesar's - Hot 'N Ready!",
						JOptionPane.YES_NO_OPTION);
				if (exitOption == 0) {
					JOptionPane.showMessageDialog(null, "Thank you for choosing Little Caesar's!", "Little Caesar's - Hot 'N Ready!",
							JOptionPane.INFORMATION_MESSAGE, null);
					System.exit(0);
				}
			}

		}
		if (e.getSource() instanceof JComboBox) {

			drinksCost = DRINK_COST * ((Integer) cbo1.getSelectedItem() + (Integer) cbo2.getSelectedItem()
					+ (Integer) cbo3.getSelectedItem() + (Integer) cbo4.getSelectedItem());
			lblDrinkCost.setText(currency.format(drinksCost));
		}
		

	}


	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override//this method will run when the user clicks the 'X' on the menu. If the user clicks 'X' he will be asked if he would like to exit and if the user would like to leave they will receive a thank you message
	public void windowClosing(WindowEvent e) {
		exitOption = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Little Caesar's - Hot 'N Ready!",
				JOptionPane.YES_NO_OPTION);
		if (exitOption == 0) {
			JOptionPane.showMessageDialog(null, "Thank you for choosing Little Caesar's!", "Little Caesar's - Hot 'N Ready!",
					JOptionPane.INFORMATION_MESSAGE, null);
			System.exit(0);
		}

	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	//
}


