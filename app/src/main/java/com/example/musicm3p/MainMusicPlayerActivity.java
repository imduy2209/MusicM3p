package com.example.musicm3p;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class MainMusicPlayerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_music_player);

        List<Song> songs = new ArrayList<>();
        songs.add(new Song("Một vòng Việt Nam", "Tùng Dương", R.drawable.motvongvietnam, R.raw.motvongvietnam,
                "Ai đã ghim vào những thân tre\n" +
                        "Bao ký ức xót xa hỡi mẹ\n" +
                        "Ai đã ru ngủ những dòng sông\n" +
                        "Cùng êm ả chảy về hướng đông\n" +
                        "Con đã vẽ hình hài quê hương\n" +
                        "Qua những khúc hát ru của mẹ\n" +
                        "Còn bao nhiêu lời ru con vẫn chưa được nghe?\n" +
                        "Việt Nam quê hương ta đẹp lắm\n" +
                        "Mặc lửa khói dày xéo tháng năm\n" +
                        "Người Việt Nam da nâu mắt đen\n" +
                        "Thảo thơm bất khuất như cành sen\n" +
                        "Việt Nam ơi quê hương ta ơi?\n" +
                        "Biển lúa chín vàng thơm ngát trời\n" +
                        "Vọng tiếng ai hò?\n" +
                        "Vì nhớ con đò, à ơi\n" +
                        "Dậy với tôi nào\n" +
                        "Dạo với tôi nào\n" +
                        "Dạo khắp một vòng Việt Nam\n" +
                        "Nhìn non sông trời văn đất võ\n" +
                        "Cùng với tôi nào Dạo với tôi nào\n" +
                        "Dạo khắp một vòng Việt Nam\n" +
                        "Come with me! We’ll travel around Viet Nam"));
        // Thêm các bài hát khác nếu cần
        songs.add(new Song("Lao tâm khổ tứ", "Thanh Hưng", R.drawable.laotamkhotu, R.raw.laotamkhotu1,
                "Cho anh gặp lại em trước khi mình cách xa\n" +
                        "Nửa quãng đời về sau anh không phiền em nữa\n" +
                        "Dù anh biết mình chẳng có cơ hội thay đổi em nữa rồi\n" +
                        "Chỉ là, chỉ là anh nhớ thôi\n" +
                        "Em muốn sự bình yên anh quen cuộc sống vô định\n" +
                        "Em nghĩ về tương lai anh không nhiều toan tính\n" +
                        "Anh có lỗi làm e thấy ưu phiền để người thứ 3 xuất hiện\n" +
                        "Rồi mang đi mất người quan trọng nhất\n" +
                        "Trái tim đã mang tổn thương xước thêm cũng đâu nghĩa gì\n" +
                        "Vốn dĩ không là của nhau thì nay ở mai bước đi\n" +
                        "Ngày ko em có dài anh vẫn sẽ tồn tại\n" +
                        "Chỉ là còn khổ tâm gượng sống trong âm thầm\n" +
                        "Chắc anh phải cần thời gian ngắt đi cánh hoa úa tàn\n" +
                        "Lỡ buông mất duyên trời ban từ này tình yêu vỡ tan\n" +
                        "Lại lạc mất em rồi anh giống như kẻ tồi\n"+
                        "3 người về 2 lối là chính anh có tội"));
        songs.add(new Song("Đến ngày xa em","Only C", R.drawable.denngayxaem, R.raw.denngayxaem,
                "Ngọt lắm những lúc em nắm đôi tay\n" +
                        "Và hứa sẽ mãi yêu chỉ anh đây\n" +
                        "Từ khi em qua nơi này\n" +
                        "Lòng anh thấy vui biết mấy\n" +
                        "Rồi nắng sẽ mãi ấm vẫn chưa vơi\n" +
                        "Con tim vang tiếng ca vui cười\n" +
                        "Vì em mang niềm vui tới nơi anh\n" +
                        "Như người may mắn nhất trên đời\n" +
                        "Nào đâu chẳng được bấy lâu lại phải xa cách nhau\n" +
                        "Cố nén nỗi đau khi cơn mưa ngâu vụn vỡ\n" +
                        "Đêm về lại mơ, sớm rồi lại bơ vơ\n" +
                        "Còn xa em là nhớ, huh wah-ah\n" +
                        "Chỉ là đôi môi, chỉ là vài câu yêu thương thôi mà\n" +
                        "Em đã khiến anh yêu em không thể phai phôi\n" +
                        "Anh mong em đừng thay đổi vì anh đã quá yêu em mất rồi\n" +
                        "Vì yêu em, xa em quanh anh chỉ còn lại bóng tối\n" +
                        "Chờ đợi ngày mai, chờ! Chờ một ngày tương lai, chờ!\n" +
                        "Ngày ta được sánh đôi vai cùng bên nhau mãi mãi\n" +
                        "Dẫu anh có làm gì sai cũng sẽ không một ai có thể chia\n" +
                        "Hai ta chung bước mãi trên một con đường dài\n" +
                        "Con đường dài hah huh hoh-oh\n" +
                        "Con đường dài, con đường dài\n" +
                        "Con đường dài lắm, con đường dài lắm\n" +
                        "Đếm, đếm, đếm, đếm\n" +
                        "Một, hai, ba, bốn, năm, sáu, bảy ngày trôi\n" +
                        "Biết em giờ có nhớ về anh hay nhớ về ai?\n" +
                        "Bao ngày thật là dài khi anh không có em bên cạnh\n" +
                        "Anh cảm thấy rất giá lạnh\n" +
                        "Mà làm sao cho em yêu hiểu thấu khi mình không ở bên nhau\n" +
                        "Mon, Tues, Wednesday, Thursday, Friday, Saturday, Sunday, ok\n" +
                        "All week anh chẳng thể nào nghĩ về em hay nghĩ về ai\n" +
                        "Nỗi buồn thì anh không thể đếm\n" +
                        "Nỗi nhớ em thì lại càng tăng thêm\n" +
                        "Ngọt ngào đôi môi không thể nếm\n" +
                        "Phải làm sao khi không em mỗi đêm yeh-eh-eh\n" +
                        "Chỉ là đôi môi, chỉ là vài câu yêu thương thôi mà\n" +
                        "Em đã khiến anh yêu em không thể phai phôi\n" +
                        "Anh mong em đừng thay đổi vì anh đã quá yêu em mất rồi\n" +
                        "Vì yêu em, xa em quanh anh nay chỉ còn bóng tối\n" +
                        "Chờ đợi ngày mai, chờ! Chờ một ngày tương lai, chờ!\n" +
                        "Ngày ta được sánh đôi vai cùng bên nhau mãi mãi\n" +
                        "Dẫu anh có làm gì sai, cũng sẽ không một ai có thể chia\n" +
                        "Hai ta chung bước mãi trên một con đường dài\n" +
                        "Nào đâu chẳng được bấy lâu\n" +
                        "Lại phải xa cách nhau\n" +
                        "Cố nén nỗi đau khi cơn mưa ngâu vụn vỡ\n" +
                        "Đêm về lại mơ\n" +
                        "Sớm rồi lại bơ vơ\n" +
                        "Còn xa em là nhớ hohhh\n" +
                        "Chỉ là đôi môi, chỉ là vài câu yêu thương thôi mà\n" +
                        "Em đã khiến anh yêu em không thể phai phôi\n" +
                        "Anh mong em đừng thay đổi vì anh đã quá yêu em mất rồi\n" +
                        "Vì yêu em, xa em quanh anh chỉ còn lại bóng tối\n" +
                        "Chờ đợi ngày mai, chờ! Chờ một ngày tương lai, chờ!\n" +
                        "Ngày ta được sánh đôi vai cùng bên nhau mãi mãi\n" +
                        "Dẫu anh có làm gì sai, cũng sẽ không một ai có thể chia\n" +
                        "Hai ta chung bước mãi trên một con đường dài"));


        songs.add(new Song("Lặng yên","Bùi Anh Tuấn", R.drawable.langyen, R.raw.langyen,
                "Ở một nơi xa xôi bao quanh là núi đồi\n" +
                        "Chuyện tình yêu vẫn cứ như thế sinh ra là có đôi\n" +
                        "Người chọn sinh ra thôi không may bị cuốn trôi\n" +
                        "Vài mảnh đời sinh ra không cho nhau đặt cạnh nên biết đau\n" +
                        "Và giọt nước mắt cứ thế tự nhiên lăn trên hàng mi giống như đời\n" +
                        "Ngày qua mới biết mơ thôi mà sao vội trôi ngọt ngào đành chia phôi\n" +
                        "Lồng ngực còn nhói chưa thôi ngày đã sang vội phải trôi tiếp với đời\n" +
                        "Trớ trêu như đời hiển nhiên như đời\n" +
                        "Điều gì gắn kết khi những hân hoan đặt ngay cạnh bên những bẽ bàng\n" +
                        "Ràng buộc không đáng yêu thương dở dang người trong cuộc ngày thêm hoang mang\n" +
                        "Làm bạn trọn quãng mênh mang (hơ) ngày sang đêm cạn mình buông nhau khẽ khàng\n" +
                        "Để cuốn theo gió ngàn lẩn giữa những đốm vàng\n" +
                        "Tình khẽ bay nhẹ nhàng\n" +
                        "Ở một nơi xa xôi bao quanh là núi đồi\n" +
                        "Chuyện tình yêu vẫn cứ cũ như thế sinh ra là có đôi\n" +
                        "Người chọn sinh ra thôi không may bị cuốn trôi\n" +
                        "Vài mảnh đời sinh ra không cho nhau đặt cạnh nên biết đau\n" +
                        "Và giọt nước mắt cứ thế tự nhiên lăn trên hàng mi giống như đời\n" +
                        "Ngày qua mới biết mơ thôi mà sao vội trôi ngọt ngào đành chia phôi\n" +
                        "Lồng ngực còn nhói chưa thôi ngày đã sang vội phải trôi tiếp như đời\n" +
                        "Trớ trêu như đời hiển nhiên như đời\n" +
                        "Điều gì gắn kết khi những hân hoan đặt ngay cạnh bên những bẽ bàng\n" +
                        "Ràng buộc không đáng yêu thương dở dang người trong cuộc ngày thêm hoang mang\n" +
                        "Làm bạn trọn quãng mênh mang ngày sang đêm cạn mình buông nhau khẽ khàng\n" +
                        "Để cuốn theo gió ngàn lẩn giữa những đốm vàng\n" +
                        "Và giọt nước mắt cứ thế tự nhiên lăn trên hàng mi giống như đời (oh)\n" +
                        "Ngày qua mới biết mơ thôi mà sao vội trôi ngọt ngào đành chia phôi\n" +
                        "Lồng ngực còn nhói chưa thôi ngày đã sang vội phải trôi tiếp với đời\n" +
                        "Trớ trêu như đời hiển nhiên như đời\n" +
                        "Điều gì gắn kết khi những hân hoan đặt ngay cạnh bên những bẽ bàng (oh)\n" +
                        "Ràng buộc không đáng yêu thương dở dang người trong cuộc ngày thêm hoang mang\n" +
                        "Làm bạn trọn quãng mênh mang ngày sang đêm cạn mình buông nhau khẽ khàng\n" +
                        "Để cuốn theo gió ngàn lẩn giữa những đốm vàng\n" +
                        "Và giọt nước mắt cứ thế tự nhiên lăn trên hàng mi giống như đời (oh)\n" +
                        "Ngày qua mới biết mơ thôi mà sao vội trôi ngọt ngào đành chia phôi\n" +
                        "Lồng ngực còn nhói chưa thôi ngày đã sang vội phải trôi tiếp với đời\n" +
                        "Trớ trêu như đời hiển nhiên như đời\n" +
                        "Điều gì gắn kết khi những hân hoan đặt ngay cạnh bên những bẽ bàng (oh)\n" +
                        "Ràng buộc không đáng yêu thương dở dang người trong cuộc ngày thêm hoang mang\n" +
                        "Làm bạn trọn quãng mênh mang ngày sang đêm cạn mình buông nhau khẽ khàng\n" +
                        "Để cuốn theo gió ngàn lẩn giữa những đốm vàng\n" +
                        "Tình khẽ bay nhẹ nhàng\n" +
                        "Khẽ bay (khẽ bay) nhẹ nhàng (nhẹ nhàng)"));
        songs.add(new Song("Crying-Over-You"," Binz và JustaTee", R.drawable.cryingoveryou, R.raw.cryingoveryou,
                "I'm crying over you bae\n" +
                        "I'm crying over you bae, bae, bae\n" +
                        "Sẽ có những đớn đau không thành lời\n" +
                        "Sẽ có những vết thương theo một đời\n" +
                        "Dù mình đã cắn thật chặt đôi môi sau bao điều mặn đắng\n" +
                        "Nhưng sao hôm nay con tim anh quên rằng anh là người mạnh mẽ vô cùng\n" +
                        "Có lẽ đã quá lâu cho một người\n" +
                        "Giấu hết yếu đuối bên trong nụ cười\n" +
                        "Rồi vội vàng nhắm mắt chậm lại đôi chân đi sau thời gian cùng những vỡ tan\n" +
                        "I'm crying over you bae\n" +
                        "I'm crying over you bae\n" +
                        "Khi anh chẳng thể giữ mãi những cảm xúc vô tình bấy lâu\n" +
                        "I'm crying over you\n" +
                        "Chơ vơ đơn côi, bên những thứ xa xôi\n" +
                        "I'm crying over you bae\n" +
                        "I'm crying over you bae\n" +
                        "Che đi một màu trắng xoá lăn dài xuống nơi gò má này\n" +
                        "I'm crying over you\n" +
                        "Chơ vơ đơn côi, bên những thứ xa xôi\n" +
                        "I'm crying over...\n" +
                        "Chưa bao giờ em thấy anh khóc\n" +
                        "Đâu có nghĩa là nước mắt anh không rơi đâu\n" +
                        "Chỉ là không muốn em biết anh yếu đuối\n" +
                        "Nhưng em đừng để tâm nhé, anh không sao đâu\n" +
                        "Và giờ trên mắt anh lại là những giọt lệ\n" +
                        "Yêu em, anh đã quên mất, anh từng mạnh mẽ\n" +
                        "Đừng, xa anh để cho nỗi nhớ làm nhoà đi hết bức tranh anh từng vẽ\n" +
                        "Vẫn đó màu mắt xanh còn ít bình yên\n" +
                        "Váy trắng vẫn còn tinh khiết\n" +
                        "Nhưng con tim em đã lạnh hơn nhiều lắm\n" +
                        "Tình yêu anh vẫn chưa đủ để sưởi ấm cho con tim đã trải qua quá nhiều nỗi đau, anh biết chứ\n" +
                        "Em cần nhiều hơn thế, anh biết chứ\n" +
                        "Anh nào muốn nước mắt anh rơi, no\n" +
                        "Anh đâu muốn hai đứa hai nơi đâu\n" +
                        "Vì vậy anh ghét con người yếu đuối trong anh\n" +
                        "Nhưng bên em ranh giới đó rất mong manh\n" +
                        "Em cho anh cười, cho anh khóc\n" +
                        "Thay đổi nhanh trong phúc chốc\n" +
                        "Cho anh buồn cho anh vui\n" +
                        "Đưa anh qua từng cung bậc của cảm xúc, em...\n" +
                        "Và khi đi đến nơi nỗi đau em buông tay anh nơi đây, chân lạc giữa đêm, babe\n" +
                        "You don't know everytnight\n" +
                        "I'm crying over you bae (yea)\n" +
                        "I'm crying over you bae\n" +
                        "Khi anh chẳng thể giữ mãi những cảm xúc vô tình bấy lâu\n" +
                        "I'm crying over you\n" +
                        "Chơ vơ đơn côi, bên những thứ xa xôi\n" +
                        "I'm crying over you bae\n" +
                        "I'm crying over you bae\n" +
                        "Che đi một màu trắng xoá lăn dài xuống nơi gò má này\n" +
                        "Vì ngày đó anh chưa bao giờ muốn em nhìn\n" +
                        "I'm crying over\n" +
                        "I'm crying over\n" +
                        "I'm crying over\n" +
                        "I'm crying over\n" +
                        "Chơ vơ đơn côi, bên những thứ đã qua rồi\n" +
                        "I'm crying over\n" +
                        "I'm crying over\n" +
                        "I'm crying over\n" +
                        "Che đi một màu trắng xoá lăn dài xuống nơi gò má này\n" +
                        "I'm crying over you\n" +
                        "Chơ vơ đơn côi, bên những thứ xa xôi\n" +
                        "I'm crying over"
        ));
        songs.add(new Song("2AM"," BigDaddy và JustaTee", R.drawable.haiam, R.raw.haiam,
                "Anh trông theo đó, đâу\n" +
                        "Ɲhưng sao chẳng, thấу\n" +
                        "Ɲhững dấu son còn tươi trên môi hồng em từ ngàу em đi\n" +
                        "Khi bao nhiêu khó, khăn\n" +
                        "Ɓên anh nhiều lắm\n" +
                        "Ɛm nói em sẽ về đâу khi mùa đông tàn\n" +
                        "Anh nhớ em khi cơn mưa dài lạnh lùng chưa tan\n" +
                        "Anh nhớ em khi em ôm chầm vào lòng anh khóc oà\n" +
                        "Anh nhớ em khi trên vai mình còn nhiều âu lo\n" +
                        "Anh nhớ em, khi trăng vừa lên, ban đêm dài hơn ban ngàу\n" +
                        "Ϲuz Ɩ Know...\n" +
                        "Tim em bao la, mặc kệ đợi chờ người ta\n" +
                        "Ϲuz Ɩ Know...\n" +
                        "Ϲho đi bao nhiêu, nhận về khói sương thật nhiều\n" +
                        "Ϲuz Ɩ Know...\n" +
                        "Ɲơi đâу bao xa, để tìm lại mình ngàу qua\n" +
                        "Oh no uh oh…oh uh oh lời em hứa sẽ trở về...\n" +
                        "Give me ur Heart…Give me ur Love\n" +
                        "Mùa đông bên anh sao thật dài, còn em đang đi đâu miệt mài\n" +
                        "Give me ur Heart…Give me ur Love\n" +
                        "Mùa đông thương anh ôm mệt nhoài, vì em đi đâu anh chờ hoài\n" +
                        "Ϲăn phòng vẫn vậу\n" +
                        "Ϲhẳng gì ngoài những hối tiếc , nỗi nhớ em và bass\n" +
                        "Ở 1 nơi nào đó anh không haу , em liệu bâу giờ đâу ??\n" +
                        "Vẫn còn nghe những bài hát nàу haу đang saу trong vòng taу...\n" +
                        "Thật cô đơn khi anh luôn nghĩ về em sớm tối\n" +
                        "Ɲhớ mắt môi\n" +
                        "Lạc vào em , anh nhớ cả những chiều tan về đưa đón lối\n" +
                        "Và nhớ mùa tuуết rơi\n" +
                        "Anh chẳng muốn tìm về quá khứ nữa , cứ để nó đẹp và ngủ уên thôi\n" +
                        "Ϲhỉ là những tấm hình , khói thuốc , chai rượu cạn dần và 2 giờ đêm trôi…\n" +
                        "Ϲuz Ɩ know…\n" +
                        "Tim em bao la, mặc kệ đợi chờ người ta\n" +
                        "Ϲuz Ɩ know…\n" +
                        "Ϲho đi bao nhiêu, nhận về khói sương thật nhiều\n" +
                        "Ϲuz Ɩ know…\n" +
                        "Ɲơi đâу bao xa, để tìm lại mình ngàу qua\n" +
                        "Oh no uh oh…oh uh oh lời em hứa sẽ trở về...\n" +
                        "Give me ur Heart…Give me ur Love\n" +
                        "Mùa đông bên anh sao thật dài, còn em đang đi đâu miệt mài\n" +
                        "Give me ur Heart…Give me ur Love\n" +
                        "Mùa đông thương anh ôm mệt nhoài, vì em đi mãi không trở về…\n" +
                        "Ooh Ooh....\n" +
                        "Ѕao không như lời em nói khi hơi ấm đang đầу vơi\n" +
                        "Ɲgàу dài qua…\n" +
                        "Ooh Ooh....\n" +
                        "Anh chưa bao giờ đi hết con đường trắng mưa buồn rơi уea\n" +
                        "And Ooh Ooh...\n" +
                        "Ϲho đi những điều mãi mãi anh đổi lấу những tàn phai nàу\n" +
                        "Ϲòn gì đâu nào? Ooh Ooh....\n" +
                        "Ɓuông xuôi hу vọng tàn úa bên mùa đông vô tình trôi\n" +
                        "Ϲuz Ɩ know…i know know, i know know\n" +
                        "Tim em bao la, mặc kệ đợi chờ người ta\n" +
                        "Ϲho đi bao nhiêu\n" +
                        "Ɓao nhiêu chỉ là sương khói thôi\n" +
                        "Ϲuz Ɩ know, i know ngàу qua uh oh. oh uh oh\n" +
                        "Lời em hứa sẽ trở về đâу\n" +
                        "Give me ur Heart…Give me ur Love\n" +
                        "Mùa đông sao bên anh thật dài, còn em đang đi đâu miệt mài\n" +
                        "Give me ur Heart…Give me ur Love\n" +
                        "Mùa đông thương anh ôm mệt nhoài, vì em đi mãi không trở về…\n" +
                        "Hoa Ѕữa rơi vâу đầу quanh trên đường nơi anh thường đi với em\n" +
                        "Hoa Ѕữa mang anh gần em khi ngàу qua đợi chờ gió đem hương về\n" +
                        "Hoa Ѕữa rơi anh nhặt lên đưa vào taу em đặt trên mái tóc em…\n" +
                        "Hoa Ѕữa ơi sao để bên em dài lâu đâу anh đếm cánh hoa nàу...\n" +
                        "(Give me ur Heart…Give me ur Love)"
        ));


        SongAdapter adapter = new SongAdapter(this, songs);
        ListView songListView = findViewById(R.id.song_list_view);
        songListView.setAdapter(adapter);

        songListView.setOnItemClickListener((parent, view, position, id) -> {
            Song song = songs.get(position);
            Intent intent = new Intent(MainMusicPlayerActivity.this, MusicPlayerActivity.class);
            intent.putExtra("selected_song", song); // Truyền đối tượng Song được chọn
            intent.putExtra("song_index", position); // Truyền vị trí của bài hát trong danh sách
            intent.putExtra("songs_list", (Serializable) songs); // Truyền danh sách các bài hát
            startActivity(intent);
        });
    }
}
