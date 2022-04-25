package chapter02.program02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * 商场收银软件v1.1
 * 增加打折功能
 */
public class Program02 {

    private double total;   // 总计金额

    JTextField priceField;
    JTextField countField;
    JTextArea listArea;

    JComboBox discountComBox;   // 折扣下拉列表
    JLabel totalmemLabel;    // 显示总计金额的标签

    public static void main(String[] args) {
        new Program02();
    }

    // 创建窗口
    public Program02() {
        JFrame frame = new JFrame();
        JPanel content = new JPanel();
        JLabel priceLabel = new JLabel("单价:");
        JLabel countLabel = new JLabel("数量:");
        JLabel discountLabel = new JLabel("计算方式:");
        JLabel totalLabel = new JLabel("     总计:     ");
        JLabel totalmem = new JLabel("0.00");
        totalmem.setFont(new Font("黑体",Font.BOLD,30));
        priceField = new JTextField(15);
        countField = new JTextField(15);
        JButton buttonAdd = new JButton("确定");
        JButton buttonReset = new JButton("重置");
        buttonAdd.addActionListener(new MyActionListener());
        buttonReset.addActionListener(new MyActionListener());
        listArea = new JTextArea(6,25);
        String[] discounts = {"正常收费","打八折","打七折","打五折"};
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
        content.add(totalmem);
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

            if(command.equals("确定")){
                if(priceField.getText().length() != 0 && countField.getText().length() != 0){
                    double discountRate = 1;
                    switch (discountComBox.getSelectedIndex()){
                        case 0:
                            discountRate = 1;
                            break;
                        case 1:
                            discountRate = 0.8;
                            break;
                        case 2:
                            discountRate = 0.7;
                            break;
                        case 3:
                            discountRate = 0.5;
                            break;
                    }
                    // 加一条商品记录
                    total += Double.parseDouble(priceField.getText()) * Double.parseDouble(countField.getText()) * discountRate;
                    String info = "单价:"+priceField.getText()+" 数量:"+countField.getText()+" "+discountComBox.getSelectedItem()+" 合计:"+total+"\n";
                    listArea.append(info);
                    // 重置 数量和单价 标签
                    priceField.setText("");
                    countField.setText("");
                    // 更新 总计金额 标签
                    totalmemLabel.setText(total+"");
                }
            }
            if(command.equals("重置")){
                if(listArea.getText().length()!=0){
                   listArea.setText("");
                   total = 0.00;
                   totalmemLabel.setText("0.00");
                }
            }
        }
    }
}
