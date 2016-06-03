#Path

##定义Path

1. 绝对Path：完整路径
2. 相对Path（相对Root）：必须以文件分隔符开始
3. 相对Path（相对WorkFolder）：不能以文件分隔符开始
4. Define a Path from a URI

    Path path = Paths.get(URI.create("file:///rafaelnadal/tournaments/2009/BNP.txt"));

##Getting Information About a Path


##Combining Two Paths(合并两个path)

    Path base = Paths.get("C:/rafaelnadal/tournaments/2009");
    Path path_1 = base.resolve("BNP.txt");

