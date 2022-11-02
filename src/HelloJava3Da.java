import javax.swing.border.Border;
import java.applet.Applet;
import java.awt.*;
import java.lang.Object;
import java.awt.Component;
import java.awt.Canvas;
import javax.media.j3d.Canvas3D;
import java.applet.*;
import java.awt.*;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.applet.*;
import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.Canvas3D;
import java.awt.Canvas;
import javax.media.j3d.*;
import javax.vecmath.*;


public class HelloJava3Da extends Applet {
    public HelloJava3Da( ){
        setLayout(new BorderLayout());
        Canvas3D canvas3D = new Canvas3D(null);
        add("Center", canvas3D);

        BranchGroup scene = createSceneGraph();
        scene.compile();

        SimpleUniverse simpleU = new SimpleUniverse(canvas3D);

        simpleU.getViewingPlatform().setNominalViewingTransform();

        simpleU.addBranchGraph(scene);
    }

    public BranchGroup createSceneGraph() {
        BranchGroup objRoot = new BranchGroup();
        objRoot.addChild(new ColorCube(0.4));
        return objRoot;
    }

    public static void main(String[] args) {
        Frame frame = new MainFrame(new HelloJava3Da(), 256, 256);
    }
}
