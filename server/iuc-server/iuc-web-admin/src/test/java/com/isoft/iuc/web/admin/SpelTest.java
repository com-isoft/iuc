package com.isoft.iuc.web.admin;

import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.GregorianCalendar;

public class SpelTest {
    @Test
    public void test(){
        GregorianCalendar c = new GregorianCalendar();
        c.set(1856, 7, 9);

// The constructor arguments are name, birthday, and nationality.
        Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");
        StandardEvaluationContext evaluationContext = new StandardEvaluationContext(new TargetWrapper(tesla));


        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("#{ target.name }", new TemplateParserContext());

        String name = (String) exp.getValue(evaluationContext);

        System.out.print(name);
    }

    static class TargetWrapper {

        private final Object target;

        public TargetWrapper(Object target) {
            this.target = target;
        }

        /**
         * @return the target
         */
        public Object getTarget() {
            return target;
        }
    }

}