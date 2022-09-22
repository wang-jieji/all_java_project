package com.example.datastructuresandalgorithms.DataStructures.stack.util;

import org.yaml.snakeyaml.util.ArrayStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description 5、将中缀表示式 转为 后缀表达式
 * @Author WJJ
 * @Date 18/7/2022 下午9:08
 **/
public class InfixConvertSuffix {

    public static void main(String[] args) {
        System.out.println(IConversionS("12+((25+3)*4)-5"));
    }

    /**
     * @return String
     * @Author WJJ
     * @Description 具体步骤
     * 1) 初始化两个栈：运算符栈S1 和 存储中间结果的栈S2;
     * 2) 从左到右扫描中缀表达式；
     * 3) 遇到操作数时，将其压入S2;
     * 4) 遇到运算符时，比较其与S1栈顶运算符的优先级:
     * 4.1) 如果S1为空，或栈顶运算符为左括号"(", 则直接将此运算符入栈;
     * 4.2) 否则,若优先级比栈顶运算符的高，也将运算符压入S1;
     * 4.3) 否则,将S1栈顶的运算符弹出并压入到S2中,再次转到4.1)与S1中新的栈顶运算符相比较;
     * 5) 遇到括号时：
     * 5.1) 如果是左括号"(",则直接压入S1;
     * 5。2) 如果是右括号")",则依次弹出S1栈顶的运算符,并压入S2,直到遇到左括号"(“为止,此时将这一对括号丢弃;
     * 6) 重复步骤2到5,直到表达式的最右边;
     * 7) 将S1中剩余的运算符一次弹出并压入S2;
     * 8) 依次弹出S2中的元素并输出,结果的逆序即为中缀表达式对应的后缀表达式;
     * @Param * @param expression 中缀表达式 1+((2+3)*4)-5
     **/
    public static String IConversionS(String expression) {
        Stack<String> operatorStack = new Stack();
        Stack<String> resultStack = new Stack<>();
        StringBuffer resultBuffer = new StringBuffer();

        // 将表达式转为list集合
        List<String> expressionArray = InfixExpressionToList(expression);
        for (String item : expressionArray) {
            processingStack(item, operatorStack, resultStack);
        }
        //将S1中剩余的运算符一次弹出并压入S2;
        while (!operatorStack.empty()) {
            resultStack.push(operatorStack.pop());
        }

        List<String> resultList = new ArrayList<>();
        while (!resultStack.empty()) {
            resultList.add(resultStack.pop());
        }

        for (int i = resultList.size() - 1; i >= 0; i--) {
            resultBuffer.append(resultList.get(i));
            if (i > 0) {
                resultBuffer.append(" ");
            }
        }

        String result = resultBuffer.toString();
        return result;
    }

    public static List<String> InfixExpressionToList(String expression) {
        List<String> expressionList = new ArrayList<>();
        int i = 0;
        char c;
        String str = "";
        do {
            c = expression.charAt(i);

            // 判断字符是否是非数字 ASCII码中0-9字符对应是48-57
            if ((c = expression.charAt(i)) < 48 || (c = expression.charAt(i)) > 57) {
                expressionList.add(c + "");
                i++;
            } else {
                str = "";
                while (i < expression.length() && (c = expression.charAt(i)) >= 48 && (c = expression.charAt(i)) <= 57) {
                    str += c;
                    i++;

                }
                expressionList.add(str);
            }
        } while (i < expression.length());
        return expressionList;

    }

    /**
     * @Author WJJ
     * @Description 根据当前字符串处理栈
     **/
    public static void processingStack(String item, Stack<String> operatorStack, Stack<String> resultStack) {
        // 判断当前字符是否是运算符
        if (isOperator(item)) {
            // 如果S1栈为空 或者 当前符号是左括号"(" 或者 或栈顶运算符为左括号"("，则直接入栈
            if (operatorStack.empty() || "(".equals(item) || "(".equals(operatorStack.peek())) {
                operatorStack.push(item);
            } else {
                // 判断当前运算符是否是右括号")",依次弹出S1栈顶的运算符,并压入S2,直到遇到左括号"(“为止,此时将这一对括号丢弃;
                if (")".equals(item)) {
                    while (!"(".equals(operatorStack.peek())) {
                        // 将栈顶元素压入S2
                        resultStack.push(operatorStack.pop());
                    }
                    // 退出循环时，栈顶为左括号 ”（“，需要将括号清除
                    operatorStack.pop();
                } else {
                    // 如果当前运算符优先级比栈顶运算符的高，压入S1
                    if (priority(item) > priority(operatorStack.peek())) {
                        operatorStack.push(item);
                    } else {
                        // 如果当前运算符优先级比栈顶运算符的小或相等,将S1栈顶的运算符弹出并压入到S2中,重新比较运算符的优先级
                        resultStack.push(operatorStack.pop());
                        processingStack(item, operatorStack, resultStack);
                    }
                }

            }

        } else {
            resultStack.push(item);
        }
    }


    /**
     * @Author WJJ
     * @Description 判断是否是一个运算符
     **/
    public static boolean isOperator(String value) {
        return "+".equals(value) || "-".equals(value) || "*".equals(value) || "/".equals(value) || "(".equals(value) || ")".equals(value);
    }

    /**
     * @Author WJJ
     * @Description 返回运算符的优先级 优先级由程序员来确定
     **/
    public static int priority(String str) {
        int operator = str.charAt(0);
        if (operator == '*' || operator == '/') {
            return 1;
        } else if (operator == '+' || operator == '-') {
            return 0;
        } else {
            return -1;
        }
    }

}
