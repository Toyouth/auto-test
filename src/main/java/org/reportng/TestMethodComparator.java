package org.reportng;

import org.testng.ITestNGMethod;

import java.util.Comparator;

/**
 * @author 喻海洋
 * Created Time: 2018/05/18 下午4:51
 */
class TestMethodComparator implements Comparator<ITestNGMethod> {
    TestMethodComparator() {
    }

    @Override
    public int compare(ITestNGMethod method1, ITestNGMethod method2) {
        int compare = method1.getRealClass().getName().compareTo(method2.getRealClass().getName());
        if (compare == 0) {
            compare = method1.getMethodName().compareTo(method2.getMethodName());
        }

        return compare;
    }
}
