package demo;

import java.awt.Color;
import java.awt.Font;

import util.AddContent2Picture;

/**
 * 描述：可以用于生成自定义的水印
 * @author BrokenColor
 * @date 2018年10月12日
 */
public class PictureDemo {

	public static void main(String[] args) {
		Font font = new Font("宋体", Font.PLAIN, 75);
		Color fontcolor = new Color(0, 0, 0);//字体颜色
		String srcImg = "";//文件背景图
		String tarImgPath = "";//出输出路径
		String msg = "亲爱的某某：\n  您好！\n  我们诚心邀请您出席我们组织于2018.6.8在某某广场举行的庆功会。\n  我们期待您的到临！";
		        String footer = "某某组织\n2018年5月19";
		        /*
		         * 图片生成
		         */
		AddContent2Picture test = new AddContent2Picture.Builder()
		                .srcpath(srcImg)//背景图
		                .outImagPath(tarImgPath)//输出
		                .border(0)//边界
		                .lineHeight(0)//文字行间距
		                .contentPosition(90, 100)//文字内容开始位置
		        .create();
		test.addMsg(msg, footer, fontcolor, font);
		test.outPutFile("jpg", "outputfilename");

	}

}
