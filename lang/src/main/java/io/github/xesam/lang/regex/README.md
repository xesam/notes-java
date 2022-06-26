# Regex

由于 正则表达式 有规范的语法，Java 也有自身的语法，因此在叠加了两者转义字符的时候，写起来就很感人了。

比如，一个字符串文本：

    a slash "\"
    
由于 \ 在正则表达式里也是用来表示转义的，如果用正则语法来写，这个模式应该是：

    a slash "\\"

    
由于 " 和 \ 在 Java 字符串表示上有特殊的意义，因此再叠加一下 Java 的语法 buff，最终在 Java 的 regex 上需要表示为：
                                
    a slash \"\\\\\"

## Pattern

Pattern 是不可变的，因此是线程安全的。

    Pattern.matches(regexStr, str)

这个静态方法测试的是整个被测字符串与表达式的匹配结果。


## Matcher

    aPattern.matcher(str)

## bounds

需要注意 anchor 的含义。

https://www.demo2s.com/android/android-matcher-useanchoringbounds-boolean-b-sets-the-anchoring-of-re.html

https://www.demo2s.com/android/android-matcher-usetransparentbounds-boolean-b-sets-the-transparency.html