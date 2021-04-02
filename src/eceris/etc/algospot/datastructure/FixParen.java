package eceris.etc.algospot.datastructure;

//https://algospot.com/judge/problem/read/FIXPAREN

import java.util.Stack;

public class FixParen {
    public static class Item {
        String value;
        boolean checked;

        public Item(String value) {
            this.value = value;
            this.checked = false;
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
        }

    }

    public static final String SOURCE = "(}";
    public static final String PRIORITY = "{(<[";
//    public static final String SOURCE = "()([)>";
//    public static final String PRIORITY = "<({[";
    public static final Stack<Item> STACK = new Stack<>();
    public static final Stack<Item> TEMP = new Stack<>();

    public static void main(String[] args) {
        for (int i = 0; i < SOURCE.length(); i++) {
            String source = SOURCE.substring(i, i + 1);

            if (STACK.empty()) {
                Item item = new Item(source);
                item.setChecked(false);
                STACK.push(item);
                continue;
            }

            if (isCorrespondingParenthesis(STACK.peek().value, source)) {
                Item item = new Item(source);
                item.setChecked(true);
                STACK.push(item);
                continue;
            }

            if (isClosedParenthesis(source)) {
                Item closeParenthesisItem = null;
                while (true) {
                    if (STACK.isEmpty()) {
                        break;
                    }
                    Item target = STACK.pop();

                    if (target.checked == true) {
                        TEMP.push(target);
                    } else {
                        String compareParenthesis = getCorrespondingParenthesis(source);
                        if (isSourceHigherThanTarget(target.value, compareParenthesis)) {
                            compareParenthesis = getCorrespondingParenthesis(compareParenthesis);
                            Item openParenthesisItem = new Item(compareParenthesis);
                            openParenthesisItem.setChecked(true);
                            TEMP.push(openParenthesisItem);

                            closeParenthesisItem = new Item(source);
                            closeParenthesisItem.setChecked(true);
                            break;
                        } else {
                            String openParenthesis = getCorrespondingParenthesis(source);
                            Item openParenthesisItem = new Item(openParenthesis);
                            openParenthesisItem.setChecked(true);
                            TEMP.push(openParenthesisItem);

                            closeParenthesisItem = new Item(source);
                            closeParenthesisItem.setChecked(true);
                            break;
                        }
                    }
                }
                while(!TEMP.empty()) {
                    STACK.push(TEMP.pop());
                }
                STACK.push(closeParenthesisItem);
                continue;
            }
            Item item = new Item(source);
            item.setChecked(false);
            STACK.push(item);
        }
        print();
    }

    public static void print() {
        for (Item i : STACK) {
            System.out.print(i.value + " ");
        }
    }

    public static boolean isSourceHigherThanTarget(String source, String target) {
        //source가 target보다 우선순위가 크냐?
        if (PRIORITY.indexOf(source) < PRIORITY.indexOf(target)) {
            return true;
        }
        return false;
    }

    public static boolean isClosedParenthesis(String parenthesis) {
        if (parenthesis.equals(")") || parenthesis.equals("}") || parenthesis.equals("]") || parenthesis.equals(">")) {
            return true;
        }
        return false;
    }

    public static boolean isCorrespondingParenthesis(String source, String target) {
        if (source.equals("(") && target.equals(")")) {
            return true;
        }
        if (source.equals("{") && target.equals("}")) {
            return true;
        }
        if (source.equals("[") && target.equals("]")) {
            return true;
        }
        if (source.equals("<") && target.equals(">")) {
            return true;
        }
        return false;
    }

    public static String getCorrespondingParenthesis(String value) {
        if (value.equals("(")) {
            return ")";
        }
        if (value.equals(")")) {
            return "(";
        }

        if (value.equals("{")) {
            return "}";
        }
        if (value.equals("}")) {
            return "{";
        }

        if (value.equals("[")) {
            return "]";
        }
        if (value.equals("]")) {
            return "[";
        }

        if (value.equals("<")) {
            return ">";
        }
        if (value.equals(">")) {
            return "<";
        }
        return "";
    }
}
