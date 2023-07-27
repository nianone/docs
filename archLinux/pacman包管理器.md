https://blog.csdn.net/u010087338/article/details/122489289

 定期检查孤立包
更新系统后，有些软件包不再作为依赖，或者不再属于官方仓库。您可以定期用以下命令清除或查看它们

```text
pacman -Qtdq | pacman -Rns -  # 递归删除孤立软件包及其配置文件
$ pacman -Qqd | pacman -Rsu --print -  # 查看循环依赖、额外依赖
$ pacman -Qm  # 查看不属于远程仓库的软件包，请注意下面要介绍的 AUR 软件包也包括在其中
```
