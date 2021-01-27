package com.soucod.addutil.commons.lang.function;

/**
 * Description:
 * A function that accepts two arguments and produces a boolean result. This is the {@code boolean}-producing primitive
 * specialization for {@link BiFunction}.
 *
 * @param <T> the type of the first argument to the function.
 * @param <U> the type of the second argument to the function.
 * Author: LuDaShi
 * Date: 2021-01-27-9:41
 * UpdateDate: 2021-01-27-9:41
 * FileName: ToBooleanBiFunction
 * Version: 0.0.0.1
 * Since: 0.0.0.1
 */
@FunctionalInterface
public interface ToBooleanBiFunction<T, U> {

    /**
     * Applies this function to the given arguments.
     *
     * @param t the first function argument.
     * @param u the second function argument.
     * @return the function result.
     */
    boolean applyAsBoolean(T t, U u);
}
