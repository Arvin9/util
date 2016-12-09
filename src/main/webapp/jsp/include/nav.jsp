<%@ page contentType="text/html;charset=UTF-8" language="java" %>



    <div data-options="region:'north'" style="height:100px">
        <h2>标题头</h2>
    </div>

    <div data-options="region:'south',split:true" style="height:50px;">
        <h3>页脚</h3>
    </div>

    <div data-options="region:'east',split:true" title="East" style="width:180px;">
        <ul class="easyui-tree" data-options="url:'tree_data1.json',method:'get',animate:true,dnd:true"></ul>
    </div>

    <div data-options="region:'west',split:true" title="菜单" style="width:150px;">
        <div class="easyui-accordion" data-options="fit:true,border:false">
            <div title="Title1" style="padding:10px;">
                content1
            </div>
            <div title="Title2" data-options="selected:true" style="padding:10px;">
                content2
            </div>
            <div title="Title3" style="padding:10px">
                content3
            </div>
        </div>
    </div>
