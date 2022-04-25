package chapter02.program04;

import chapter02.program04.cash.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 商场收银软件v1.3
 * 利用策略模式
 */
public class Program04 {

    private double total;   // 所有商品总计金额

    JTextField priceField;  // 单价框
    JTextField countField;  // 数量框
    JTextArea listArea;     // 记录购买商品列表

    JComboBox discountComBox;   // 折扣下拉列表
    String[] discounts = {"正常收费","满300返100","打8折"}; // 折扣列表

    JLabel totalmemLabel;    // 显示总计金额的标签

    public static void main(String[] args) {
        new Program04();
    }

    // 创建窗口
    public Program04() {
        JFrame frame = new JFrame();
        JPanel content = new JPanel();
        JLabel priceLabel = new JLabel("单价:");
        JLabel countLabel = new JLabel("数量:");
        JLabel discountLabel = new JLabel("计算方式:");
        JLabel totalLabel = new JLabel("     总计:     ");
        totalmemLabel = new JLabel("0.00");
        totalmemLabel.setFont(new Font("黑体",Font.BOLD,30));
        priceField = new JTextField(15);
        countField = new JTextField(15);
        JButton buttonAdd = new JButton("确定");
        JButton buttonReset = new JButton("重置");
        buttonAdd.addActionListener(new MyActionListener());
        buttonReset.addActionListener(new MyActionListener());
        listArea = new JTextArea(6,25);

        discountComBox = new JComboBox(discounts);

        content.add(priceLabel);
        content.add(priceField);
        content.add(buttonAdd);
        content.add(countLabel);
        content.add(countField);
        content.add(buttonReset);

        content.add(discountLabel);
        content.add(discountComBox);
        content.add(listArea);
        content.add(totalLabel);
        content.add(totalmemLabel);
        content.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));

        frame.add(content);
        frame.setTitle("商城收银系统");
        frame.setBounds(200,200,310,320);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    // 处理按钮事件
    class MyActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if(command.equals("确定")) {
                if (priceField.getText().length() != 0 && countField.getText().length() != 0) { // 验证输入框数据长度不为0

                    CashContent cc = null;
                    switch (discountComBox.getSelectedItem().toString()) {
                        case "正常收费":
                            cc = new CashContent(new CashNormal());
                            break;
                        case "满300返100":
                            cc = new CashContent(new CashRetrun(300, 100));
                            break;
                        case "打8折":
                            cc = new CashContent(new CashRebate(0.8));
                            break;
                    }
                    // 通过对Context的GetResult方法的调用，可以得到收取费用的结果，让具体算法与客户端进行了隔离
                    double totalPrices = cc.getResult(Double.parseDouble(priceField.getText()) * Double.parseDouble(countField.getText()));

                    total = total + totalPrices;    // 所有商品的总计

                    // 向商品列表添加一条记录
                    String info = "单价:" + priceField.getText() + " 数量:" + countField.getText() + " " + discountComBox.getSelectedItem() + " 合计:" + total + "\n";
                    listArea.append(info);
                    // 更新所有商品的总价
                    totalmemLabel.setText(total + "");
                    // 重置 数量和单价
                    priceField.setText("");
                    countField.setText("");
                }
            }
            else if(command.equals("重置")){
                if(listArea.getText().length()!=0){
                   listArea.setText("");
                   total = 0.00;
                   totalmemLabel.setText("0.00");
                }
            }
        }
    }
}
