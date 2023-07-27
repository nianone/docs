# Git 安装配置
> git config命令的–global参数，用了这个参数，表示你这台机器上所有的Git仓库都会使用这个配置，当然也可以对某个仓库指定不同的用户名和Email地址。

# 1.查看git配置信息
```bash
git config --list
```
# 2.查看git用户名、密码、邮箱的配置
```bash
git config user.name
git config user.password
git config user.email
```

# 3.修改git用户名、密码、邮箱的配置（全局配置）
```bash
git config --global user.name "freedom"
```

# git 提交规范
```text
修改类型(影响范围): 标题
<--空行-->
[正文]
<--空行-->
[页脚]
```

```
feat：提交新功能
fix：修复了bug
docs：只修改了文档
style：调整代码格式，未修改代码逻辑（比如修改空格、格式化、缺少分号等）
refactor：代码重构，既没修复bug也没有添加新功能
perf：性能优化，提高性能的代码更改
test：添加或修改代码测试
chore：对构建流程或辅助工具和依赖库（如文档生成等）的更改
```