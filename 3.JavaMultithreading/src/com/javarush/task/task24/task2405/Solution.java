package com.javarush.task.task24.task2405;

/* 
Black box
*/

public class Solution implements Action {
    public static int countActionObjects;

    private int param;

    private Action solutionAction = new Action() {

        public void someAction() {
            if (param > 0) {
                // Reverse countdown
                while (param > 0) {
                    System.out.println(param--);
                }
                //New FirstClass anonymous class. This class'es someAction() overridden to create new SecondClass anonymous class.
                new FirstClass() {
                    @Override
                    public void someAction() {
                        //FirstClass not-overridden method call.
                        super.someAction();
                        //New SecondClass anonymous class. This class'es someAction() overridden to print without new line
                        new SecondClass(){
                            @Override
                            public void someAction() {
                                System.out.print(sb.toString());
                            }
                        }.someAction(); //FirstClass overridden method call
                        System.out.println(SecondClass.SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM + param);
                    }

                    @Override
                    public Action getDependantAction() {
                        return null;
                    }
                }.someAction();
            } else {
                //New SecondClass anonymous class. This class'es someAction() overridden to print needed message;
                new SecondClass() {
                    @Override
                    public void someAction() {
                        System.out.println(sb.append(SecondClass.SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM).append(param).toString());
                    }
                }.someAction();
            }
        }
    };


    public Solution(int param) {
        this.param = param;
    }

    @Override
    public void someAction() {
        solutionAction.someAction();
    }

    /**
     * 5
     * 4
     * 3
     * 2
     * 1
     * class FirstClass, method someAction
     * class SecondClass, method someAction
     * Specific action for anonymous SecondClass, param = 0
     * Count of created Action objects is 2
     * class SecondClass, method someAction
     * Specific action for anonymous SecondClass, param = -1
     * Count of created Action objects is 3
     */
    public static void main(String[] args) {
        Solution solution = new Solution(5);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);

        solution = new Solution(-1);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);
    }
}