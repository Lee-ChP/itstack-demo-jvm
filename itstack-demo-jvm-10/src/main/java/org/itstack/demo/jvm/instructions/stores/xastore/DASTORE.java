package org.itstack.demo.jvm.instructions.stores.xastore;

import org.itstack.demo.jvm.instructions.base.InstructionNoOperands;
import org.itstack.demo.jvm.rtda.Frame;
import org.itstack.demo.jvm.rtda.OperandStack;
import org.itstack.demo.jvm.rtda.heap.methodarea.Object;

/**
 * http://www.itstack.org
 * create by fuzhengwei on 2019/4/29
 */
public class DASTORE extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        double val = stack.popDouble();
        int idx = stack.popInt();
        Object arrRef = stack.popRef();

        checkNotNull(arrRef);
        double[] doubles = arrRef.doubles();
        checkIndex(doubles.length, idx);
        doubles[idx] = val;
    }

}
