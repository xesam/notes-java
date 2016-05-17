# 配置网络参数

JVM

    -Djava.net.preferIPv4Stack=false

设置为 false：

在 IPv6 可用的情况下，可以使用 IPv4 或者 IPv6

设置为 true：

使用 IPv4，不使用 IPv6

    -Djava.net.preferIPv6Addresses=false

设置为 false：

在 IPv6 可用的情况下，优先使用 IPv4 或者 IPv6

设置为 true：

如果 IPv6 可用，就使用 IPv6