# docker

## 容器

容器技术**只隔离应用程序的的运行时环境但容器之间可以共享同一个操作系统**，这里的运行时环境指的是程序运行以来的各种库以及配置。

容器相较于虚拟机的更加的**轻量级且占用的资源更少**，可以在同规格的硬件上**大量部署容器**，并且容器的启动速度几乎是瞬时的。

## 什么是docker

docker是一个用Go语言 实现的开源项目，docker将程序以及程序所有的依赖都打包到docker container, 这样程序就可以在任何环境都有一致的表现。

## 如何使用docker

archlinux安装docker
```text
yay -S docker

sudo systemctl enable docker
```


## 致谢参考
> https://zhuanlan.zhihu.com/p/187505981