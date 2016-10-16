package algorithms.datastructures;

public class Expression_Evaluation {

	public static void main(String as[]){
		method("314159265358", 27182);
	}
	static void recursive(double sum, double previous, String values, double target, String expr) {
		   if (values.length() == 0) {
		     if (sum + previous == target) {
		       System.out.println(expr + " = " + target);
		     }
		   } else {
		     for (int i = 1; i <= values.length(); i++) {
		       double current = Double.parseDouble(values.substring(0, i));
		       String remaining = values.substring(i);
		       recursive(sum + previous, current, remaining, target, expr + " + " + current);
		       recursive(sum, previous * current, remaining, target, expr + " * " + current);
		       recursive(sum, previous / current, remaining, target, expr + " / " + current);
		       recursive(sum + previous, -current, remaining, target, expr + " - " + current);
		     }
		   }
		 }

		 static void method(String values, double target) {
		   for (int i = 1; i <= values.length(); i++) {
		     String present_value = values.substring(0, i);
		     recursive(0, Double.parseDouble(present_value), values.substring(i), target, present_value);
		   }
		 }
}
