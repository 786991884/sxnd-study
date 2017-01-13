package ch03;

public class Reverse {
    private String input;

    public Reverse(String input) {
        this.input = input;
    }

    public String doReverse() {
        CharStack cs = new CharStack(input.length());
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            cs.push(ch);
        }
        String output = "";
        while (!cs.isEmpty()) {
            char ch = cs.pop();
            output += ch;
        }
        return output;
    }

}
