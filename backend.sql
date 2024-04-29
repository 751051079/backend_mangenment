/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80300
 Source Host           : localhost:3306
 Source Schema         : backend

 Target Server Type    : MySQL
 Target Server Version : 80300
 File Encoding         : 65001

 Date: 30/04/2024 00:11:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` bigint NOT NULL,
  `menu_id` bigint DEFAULT NULL COMMENT '菜单Id',
  `menu_name` varchar(255) COLLATE utf32_vietnamese_ci DEFAULT NULL COMMENT '菜单名称',
  `menu_key` varchar(255) COLLATE utf32_vietnamese_ci DEFAULT NULL COMMENT '菜单标识',
  `component` varchar(255) COLLATE utf32_vietnamese_ci DEFAULT NULL COMMENT '菜单布局',
  `parent_id` bigint DEFAULT NULL COMMENT '父菜单布局',
  `target` varchar(255) COLLATE utf32_vietnamese_ci DEFAULT NULL COMMENT '打开方式',
  `order_num` int DEFAULT NULL COMMENT '显示顺序',
  `menu_type` char(1) COLLATE utf32_vietnamese_ci DEFAULT NULL COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` int DEFAULT NULL COMMENT '菜单状态（0显示 1隐藏）',
  `perms` varchar(255) COLLATE utf32_vietnamese_ci DEFAULT NULL COMMENT '权限标识',
  `path` varchar(255) COLLATE utf32_vietnamese_ci DEFAULT NULL COMMENT '链接',
  `redirect` varchar(255) COLLATE utf32_vietnamese_ci DEFAULT NULL COMMENT '重定向',
  `hidden_children` int DEFAULT NULL COMMENT '强制菜单显示为Item而不是SubItem',
  `hidden_header` int DEFAULT NULL COMMENT '特殊 隐藏 PageHeader 组件中的页面带的 面包屑和页面标题栏',
  `create_by` varchar(255) COLLATE utf32_vietnamese_ci DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` datetime DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) COLLATE utf32_vietnamese_ci DEFAULT NULL COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_vietnamese_ci;

-- ----------------------------
-- Records of menu
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint NOT NULL COMMENT 'id',
  `role_id` bigint DEFAULT NULL COMMENT '角色id',
  `role_name` varchar(255) COLLATE utf32_vietnamese_ci DEFAULT NULL COMMENT '角色名称',
  `role_key` varchar(255) COLLATE utf32_vietnamese_ci DEFAULT NULL COMMENT '角色权限字符串',
  `role_sort` int DEFAULT NULL COMMENT '显示顺序',
  `data_scope` char(1) COLLATE utf32_vietnamese_ci DEFAULT NULL COMMENT '数据范围（1全部数据权限2自定义数据权限）',
  `status` char(1) COLLATE utf32_vietnamese_ci DEFAULT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` varchar(255) COLLATE utf32_vietnamese_ci DEFAULT NULL COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(255) COLLATE utf32_vietnamese_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) COLLATE utf32_vietnamese_ci DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) COLLATE utf32_vietnamese_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_vietnamese_ci;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint DEFAULT NULL,
  `username` varchar(255) COLLATE utf32_vietnamese_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf32_vietnamese_ci DEFAULT NULL,
  `status` int DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_vietnamese_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`id`, `username`, `password`, `status`, `create_time`, `update_time`) VALUES (1776532093605187586, 'admin', 'e10adc3949ba59abbe56e057f20f883e', 1, '2024-04-06 16:47:12', '2024-04-06 16:47:12');
INSERT INTO `user` (`id`, `username`, `password`, `status`, `create_time`, `update_time`) VALUES (1777360150775660545, 'admin1', 'e10adc3949ba59abbe56e057f20f883e', 1, '2024-04-08 23:37:36', '2024-04-08 23:37:36');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
