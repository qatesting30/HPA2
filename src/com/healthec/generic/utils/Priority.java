package com.healthec.generic.utils;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Priority implements IMethodInterceptor{

        @Override
        public List<IMethodInstance> intercept(List<IMethodInstance> list, ITestContext iTestContext) {

            /*********comare methods by name*********/
            Collections.sort(list, new MethodComparator());
            return list;

            /*********comare methods by line no*********/
            /*Comparator<IMethodInstance> comparator = new Comparator<IMethodInstance>() {
                    private int getLineNo(IMethodInstance mi) {
                        int result = 0;

                        String methodName = mi.getMethod().getConstructorOrMethod().getMethod().getName();
                        String className  = mi.getMethod().getConstructorOrMethod().getDeclaringClass().getCanonicalName();
                        ClassPool pool    = ClassPool.getDefault();

                        try {
                            CtClass cc        = pool.get(className);
                            CtMethod ctMethod = cc.getDeclaredMethod(methodName);
                            result            = ctMethod.getMethodInfo().getLineNumber(0);
                        } catch (NotFoundException e) {
                            e.printStackTrace();
                        }

                        return result;
                    }

                    public int compare(IMethodInstance m1, IMethodInstance m2) {
                        return getLineNo(m1) - getLineNo(m2);
                    }
                };

                IMethodInstance[] array = methods.toArray(new IMethodInstance[methods.size()]);
                Arrays.sort(array, comparator);
                return Arrays.asList(array);*/
            }
        }









