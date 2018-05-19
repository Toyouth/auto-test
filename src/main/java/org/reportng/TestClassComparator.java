package org.reportng;

import org.testng.IClass;

import java.util.Comparator;

/**
 * @author 喻海洋
 * Created Time: 2018/05/18 下午4:50
 */
class TestClassComparator implements Comparator<IClass> {
    TestClassComparator() {
    }

    @Override
    public int compare(IClass class1, IClass class2) {
        return class1.getName().compareTo(class2.getName());
    }
}
