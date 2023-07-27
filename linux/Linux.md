# 1.systemd 初始化进程服务

```bash
systemctl start httpd 			# 启动服务
systemctl restart httpd			# 重启服务
systemctl stop httpd			# 停止服务
systemctl reload httpd			# 重新加载配置文件（不终止服务）
systemctl status httpd			# 查看服务状态
systemctl enable httpd			# 开机自动启动
systemctl disable httpd			# 开机不自动启动
systemctl is-enabled httpd		# 查看特定服务是否为开机自启动
systemctl list-unit-files--type=httpd		# 查看各个级别下服务的启动与禁用情况

```

# 2.常用命令

2.1.echo 在终端设备上输出字符串或变量提取后的值

```
echo LinuxProbe.com
```

