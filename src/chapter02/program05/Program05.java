package chapter02.program05;

import chapter02.program05.cash.CashContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 商场收银软件v1.4
 * 策略与简单工厂结合
 * 策略与简单工厂结合的用法，耦合更加降低，使得收费算法彻底地与客户端分离
 * 策略模式解析：
 * 1.策略模式是一种定义一系列算法的方法，从概念来看，所有这些算法完成的都是相同的工作，
 *   只是实现不同，它可以以相同的方式调用所有的算法，减少了各种算法类与使用算法类之间的耦合。
 * 2.策略模式的Strategy类层次为Context定义了一系列的可供重用的算法或行为。继承有助于析取出这些算法中的公共功能。
 * 3.另外一个策略模式的优点时简化了单元测试，因为每个算法都有自己的类，可以通过自己的接口单独测试。
 * 4.当不同的行为堆砌在一个类中时，就很难避免使用条件语句来选择合适的行为。将这些行为封装在一个个独立的Strategy类中，
 *   可以在使用这类行为的类中消除条件语句。
 * 5.策略模式就是用来封装算法的，但在实践中，我们发现可以用它来封装几乎任何类型的规则，只要在分析过程中听到需要在不同时间应用不同的业务规则，
 *   就可以考虑使用策略模式处理这种变化的可能性。
 * 6.在基本的策略模式中，选择所用具体实现的职责由客户端对象承担，并转给策略模式的Context对象。
 *   这本身并没有解决客户端需要选择判断的压力，而策略模式与简单工厂模式结合后，选择具体实现的职责也可以有Context来承担，最大化减轻了客户端的职责。
 */
public class Program05 {

    private double total;   // 所有商品总计金额

    JTextField priceField;  // 单价框
    JTextField countField;  // 数量框
    JTextArea listArea;     // 记录购买商品列表

    JComboBox discountComBox;   // 折扣下拉列表
    String[] discounts = {"正常收费","满300返100","打8折"}; // 折扣列表

    JLabel totalmemLabel;    // 显示总计金额的标签

    public static void main(String[] args) {
        new Program05();
    }

    // 创建窗口
    public Program05() {
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

                    // 根据下拉选择框，将相应的算法类型字符串传入CashContext的对象中
                    CashContext cashContext = new CashContext(discountComBox.getSelectedItem() + "");
                    // 通过多态可以得到收费的结果(一种商品的合计  数量*单价[*优惠])
                    double totalPrices = cashContext.getResult(Double.parseDouble(priceField.getText()) * Double.parseDouble(countField.getText()));
                    total += totalPrices;    // 所有商品的总计

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
