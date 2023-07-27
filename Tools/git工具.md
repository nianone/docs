# Git 安装配置

# 1.基本设置

```bash
git config --list # 查看当前git配置信息
git config --global -l #查看全局git配置信息
git config --global user.name #设置全局用户名，也是git提交中的名称
git config --global user.email #设置全局邮箱
# 去掉global则是设置当前仓库的信息
```

# 2.常用命令

### 2.1.初始化仓库

```bash
git init
```

### 2.2.克隆仓库

```bash
git clone <url>
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