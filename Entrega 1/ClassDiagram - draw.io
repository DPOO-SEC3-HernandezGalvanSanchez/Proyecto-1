<mxfile host="app.diagrams.net" modified="2022-03-02T03:14:02.600Z" agent="5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36 Edg/98.0.1108.62" etag="khkaH56tWan-xntf7DFU" version="16.6.4" type="github">
  <diagram id="C5RBs43oDa-KdzZeNtuy" name="Page-1">
    <mxGraphModel dx="1483" dy="827" grid="1" gridSize="10" guides="1" tooltips="1" connect="1" arrows="1" fold="1" page="1" pageScale="1" pageWidth="980" pageHeight="690" math="0" shadow="0">
      <root>
        <mxCell id="WIyWlLk6GJQsqaUBKTNV-0" />
        <mxCell id="WIyWlLk6GJQsqaUBKTNV-1" parent="WIyWlLk6GJQsqaUBKTNV-0" />
        <mxCell id="gvsdgywLlCYybCyVyM71-7" style="edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;exitX=0.5;exitY=1;exitDx=0;exitDy=0;entryX=0.469;entryY=-0.009;entryDx=0;entryDy=0;entryPerimeter=0;fontSize=16;" edge="1" parent="WIyWlLk6GJQsqaUBKTNV-1" source="SelwD84V-lnaNtGyxA-m-0" target="SelwD84V-lnaNtGyxA-m-13">
          <mxGeometry relative="1" as="geometry" />
        </mxCell>
        <mxCell id="gvsdgywLlCYybCyVyM71-8" value="*" style="edgeLabel;html=1;align=center;verticalAlign=middle;resizable=0;points=[];fontSize=16;" vertex="1" connectable="0" parent="gvsdgywLlCYybCyVyM71-7">
          <mxGeometry x="0.6971" relative="1" as="geometry">
            <mxPoint as="offset" />
          </mxGeometry>
        </mxCell>
        <mxCell id="SelwD84V-lnaNtGyxA-m-0" value="Proyecto" style="swimlane;fontStyle=1;childLayout=stackLayout;horizontal=1;startSize=26;fillColor=none;horizontalStack=0;resizeParent=1;resizeParentMax=0;resizeLast=0;collapsible=1;marginBottom=0;" parent="WIyWlLk6GJQsqaUBKTNV-1" vertex="1">
          <mxGeometry x="399" y="192" width="140" height="130" as="geometry" />
        </mxCell>
        <mxCell id="SelwD84V-lnaNtGyxA-m-1" value="nombre: String" style="text;strokeColor=none;fillColor=none;align=left;verticalAlign=top;spacingLeft=4;spacingRight=4;overflow=hidden;rotatable=0;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;" parent="SelwD84V-lnaNtGyxA-m-0" vertex="1">
          <mxGeometry y="26" width="140" height="26" as="geometry" />
        </mxCell>
        <mxCell id="SelwD84V-lnaNtGyxA-m-3" value="descripcion: String" style="text;strokeColor=none;fillColor=none;align=left;verticalAlign=top;spacingLeft=4;spacingRight=4;overflow=hidden;rotatable=0;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;" parent="SelwD84V-lnaNtGyxA-m-0" vertex="1">
          <mxGeometry y="52" width="140" height="26" as="geometry" />
        </mxCell>
        <mxCell id="SelwD84V-lnaNtGyxA-m-7" value="fechaInicio: date*" style="text;strokeColor=none;fillColor=none;align=left;verticalAlign=top;spacingLeft=4;spacingRight=4;overflow=hidden;rotatable=0;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;" parent="SelwD84V-lnaNtGyxA-m-0" vertex="1">
          <mxGeometry y="78" width="140" height="26" as="geometry" />
        </mxCell>
        <mxCell id="SelwD84V-lnaNtGyxA-m-6" value="fechaFinalizacion: date*" style="text;strokeColor=none;fillColor=none;align=left;verticalAlign=top;spacingLeft=4;spacingRight=4;overflow=hidden;rotatable=0;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;" parent="SelwD84V-lnaNtGyxA-m-0" vertex="1">
          <mxGeometry y="104" width="140" height="26" as="geometry" />
        </mxCell>
        <mxCell id="SelwD84V-lnaNtGyxA-m-25" value="*" style="edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;fontSize=16;entryX=1.018;entryY=0.278;entryDx=0;entryDy=0;entryPerimeter=0;" parent="WIyWlLk6GJQsqaUBKTNV-1" source="SelwD84V-lnaNtGyxA-m-8" target="SelwD84V-lnaNtGyxA-m-15" edge="1">
          <mxGeometry x="0.8808" relative="1" as="geometry">
            <mxPoint x="615" y="502" as="targetPoint" />
            <Array as="points">
              <mxPoint x="765" y="572" />
              <mxPoint x="615" y="572" />
            </Array>
            <mxPoint as="offset" />
          </mxGeometry>
        </mxCell>
        <mxCell id="SelwD84V-lnaNtGyxA-m-8" value="Participante" style="swimlane;fontStyle=1;childLayout=stackLayout;horizontal=1;startSize=26;fillColor=none;horizontalStack=0;resizeParent=1;resizeParentMax=0;resizeLast=0;collapsible=1;marginBottom=0;" parent="WIyWlLk6GJQsqaUBKTNV-1" vertex="1">
          <mxGeometry x="725" y="218" width="140" height="78" as="geometry" />
        </mxCell>
        <mxCell id="SelwD84V-lnaNtGyxA-m-9" value="nombre: String" style="text;strokeColor=none;fillColor=none;align=left;verticalAlign=top;spacingLeft=4;spacingRight=4;overflow=hidden;rotatable=0;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;" parent="SelwD84V-lnaNtGyxA-m-8" vertex="1">
          <mxGeometry y="26" width="140" height="26" as="geometry" />
        </mxCell>
        <mxCell id="SelwD84V-lnaNtGyxA-m-10" value="correo: String" style="text;strokeColor=none;fillColor=none;align=left;verticalAlign=top;spacingLeft=4;spacingRight=4;overflow=hidden;rotatable=0;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;" parent="SelwD84V-lnaNtGyxA-m-8" vertex="1">
          <mxGeometry y="52" width="140" height="26" as="geometry" />
        </mxCell>
        <mxCell id="SelwD84V-lnaNtGyxA-m-13" value="Actividad" style="swimlane;fontStyle=1;childLayout=stackLayout;horizontal=1;startSize=26;fillColor=none;horizontalStack=0;resizeParent=1;resizeParentMax=0;resizeLast=0;collapsible=1;marginBottom=0;" parent="WIyWlLk6GJQsqaUBKTNV-1" vertex="1">
          <mxGeometry x="404" y="512" width="140" height="156" as="geometry" />
        </mxCell>
        <mxCell id="SelwD84V-lnaNtGyxA-m-14" value="titulo: String" style="text;strokeColor=none;fillColor=none;align=left;verticalAlign=top;spacingLeft=4;spacingRight=4;overflow=hidden;rotatable=0;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;" parent="SelwD84V-lnaNtGyxA-m-13" vertex="1">
          <mxGeometry y="26" width="140" height="26" as="geometry" />
        </mxCell>
        <mxCell id="SelwD84V-lnaNtGyxA-m-15" value="descripcion: String" style="text;strokeColor=none;fillColor=none;align=left;verticalAlign=top;spacingLeft=4;spacingRight=4;overflow=hidden;rotatable=0;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;" parent="SelwD84V-lnaNtGyxA-m-13" vertex="1">
          <mxGeometry y="52" width="140" height="26" as="geometry" />
        </mxCell>
        <mxCell id="SelwD84V-lnaNtGyxA-m-17" value="fecha: date*" style="text;strokeColor=none;fillColor=none;align=left;verticalAlign=top;spacingLeft=4;spacingRight=4;overflow=hidden;rotatable=0;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;" parent="SelwD84V-lnaNtGyxA-m-13" vertex="1">
          <mxGeometry y="78" width="140" height="26" as="geometry" />
        </mxCell>
        <mxCell id="SelwD84V-lnaNtGyxA-m-22" value="horaInicio: hour*" style="text;strokeColor=none;fillColor=none;align=left;verticalAlign=top;spacingLeft=4;spacingRight=4;overflow=hidden;rotatable=0;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;" parent="SelwD84V-lnaNtGyxA-m-13" vertex="1">
          <mxGeometry y="104" width="140" height="26" as="geometry" />
        </mxCell>
        <mxCell id="SelwD84V-lnaNtGyxA-m-21" value="horaFinalizacion: hour*" style="text;strokeColor=none;fillColor=none;align=left;verticalAlign=top;spacingLeft=4;spacingRight=4;overflow=hidden;rotatable=0;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;" parent="SelwD84V-lnaNtGyxA-m-13" vertex="1">
          <mxGeometry y="130" width="140" height="26" as="geometry" />
        </mxCell>
        <mxCell id="SelwD84V-lnaNtGyxA-m-24" value="1...*" style="edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;exitX=1;exitY=0.5;exitDx=0;exitDy=0;fontSize=16;" parent="WIyWlLk6GJQsqaUBKTNV-1" source="SelwD84V-lnaNtGyxA-m-3" target="SelwD84V-lnaNtGyxA-m-9" edge="1">
          <mxGeometry x="0.5" relative="1" as="geometry">
            <mxPoint as="offset" />
            <Array as="points">
              <mxPoint x="539" y="262" />
            </Array>
          </mxGeometry>
        </mxCell>
        <mxCell id="SelwD84V-lnaNtGyxA-m-26" style="edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;exitX=1;exitY=0.5;exitDx=0;exitDy=0;fontSize=16;entryX=0.559;entryY=0.985;entryDx=0;entryDy=0;entryPerimeter=0;" parent="WIyWlLk6GJQsqaUBKTNV-1" target="SelwD84V-lnaNtGyxA-m-10" edge="1">
          <mxGeometry relative="1" as="geometry">
            <mxPoint x="744.0000000000001" y="372" as="targetPoint" />
            <Array as="points">
              <mxPoint x="544" y="612" />
              <mxPoint x="803" y="612" />
            </Array>
            <mxPoint x="544" y="603" as="sourcePoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="SelwD84V-lnaNtGyxA-m-27" value="1" style="edgeLabel;html=1;align=center;verticalAlign=middle;resizable=0;points=[];fontSize=16;" parent="SelwD84V-lnaNtGyxA-m-26" vertex="1" connectable="0">
          <mxGeometry x="0.9004" y="1" relative="1" as="geometry">
            <mxPoint as="offset" />
          </mxGeometry>
        </mxCell>
        <mxCell id="kkZZXf0BPx9zZVAAwBUF-0" value="TipoActividad" style="swimlane;fontStyle=1;childLayout=stackLayout;horizontal=1;startSize=26;fillColor=none;horizontalStack=0;resizeParent=1;resizeParentMax=0;resizeLast=0;collapsible=1;marginBottom=0;" parent="WIyWlLk6GJQsqaUBKTNV-1" vertex="1">
          <mxGeometry x="115" y="392" width="140" height="52" as="geometry" />
        </mxCell>
        <mxCell id="kkZZXf0BPx9zZVAAwBUF-2" value="titulo: String" style="text;strokeColor=none;fillColor=none;align=left;verticalAlign=top;spacingLeft=4;spacingRight=4;overflow=hidden;rotatable=0;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;" parent="kkZZXf0BPx9zZVAAwBUF-0" vertex="1">
          <mxGeometry y="26" width="140" height="26" as="geometry" />
        </mxCell>
        <mxCell id="kkZZXf0BPx9zZVAAwBUF-4" style="edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;exitX=0;exitY=0.5;exitDx=0;exitDy=0;entryX=0.5;entryY=0;entryDx=0;entryDy=0;" parent="WIyWlLk6GJQsqaUBKTNV-1" source="SelwD84V-lnaNtGyxA-m-3" target="kkZZXf0BPx9zZVAAwBUF-0" edge="1">
          <mxGeometry relative="1" as="geometry">
            <Array as="points" />
          </mxGeometry>
        </mxCell>
        <mxCell id="kkZZXf0BPx9zZVAAwBUF-5" value="&lt;font style=&quot;font-size: 16px&quot;&gt;1...*&lt;/font&gt;" style="edgeLabel;html=1;align=center;verticalAlign=middle;resizable=0;points=[];" parent="kkZZXf0BPx9zZVAAwBUF-4" vertex="1" connectable="0">
          <mxGeometry x="0.5169" y="-1" relative="1" as="geometry">
            <mxPoint y="36" as="offset" />
          </mxGeometry>
        </mxCell>
        <mxCell id="kkZZXf0BPx9zZVAAwBUF-9" value="tiposActividades" style="edgeLabel;html=1;align=center;verticalAlign=middle;resizable=0;points=[];fontSize=14;" parent="kkZZXf0BPx9zZVAAwBUF-4" vertex="1" connectable="0">
          <mxGeometry x="-0.0957" y="-1" relative="1" as="geometry">
            <mxPoint x="14" as="offset" />
          </mxGeometry>
        </mxCell>
        <mxCell id="kkZZXf0BPx9zZVAAwBUF-6" style="edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;exitX=0;exitY=0.5;exitDx=0;exitDy=0;entryX=0.501;entryY=0.962;entryDx=0;entryDy=0;entryPerimeter=0;fontSize=16;" parent="WIyWlLk6GJQsqaUBKTNV-1" target="kkZZXf0BPx9zZVAAwBUF-2" edge="1">
          <mxGeometry relative="1" as="geometry">
            <mxPoint x="205.53999999999996" y="350.20799999999997" as="targetPoint" />
            <mxPoint x="404" y="603" as="sourcePoint" />
            <Array as="points">
              <mxPoint x="185" y="602" />
            </Array>
          </mxGeometry>
        </mxCell>
        <mxCell id="kkZZXf0BPx9zZVAAwBUF-7" value="1" style="edgeLabel;html=1;align=center;verticalAlign=middle;resizable=0;points=[];fontSize=16;" parent="kkZZXf0BPx9zZVAAwBUF-6" vertex="1" connectable="0">
          <mxGeometry x="0.8082" y="-1" relative="1" as="geometry">
            <mxPoint as="offset" />
          </mxGeometry>
        </mxCell>
        <mxCell id="gvsdgywLlCYybCyVyM71-0" style="edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;exitX=1;exitY=0.5;exitDx=0;exitDy=0;entryX=0.5;entryY=0;entryDx=0;entryDy=0;" edge="1" parent="WIyWlLk6GJQsqaUBKTNV-1" source="naoDOJTC9RyMsyCSktRx-0" target="SelwD84V-lnaNtGyxA-m-8">
          <mxGeometry relative="1" as="geometry" />
        </mxCell>
        <mxCell id="gvsdgywLlCYybCyVyM71-2" value="&lt;font style=&quot;font-size: 16px&quot;&gt;*&lt;/font&gt;" style="edgeLabel;html=1;align=center;verticalAlign=middle;resizable=0;points=[];" vertex="1" connectable="0" parent="gvsdgywLlCYybCyVyM71-0">
          <mxGeometry x="0.8055" y="6" relative="1" as="geometry">
            <mxPoint x="-6" y="-5" as="offset" />
          </mxGeometry>
        </mxCell>
        <mxCell id="gvsdgywLlCYybCyVyM71-1" style="edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;exitX=0;exitY=0.5;exitDx=0;exitDy=0;entryX=0.5;entryY=0;entryDx=0;entryDy=0;" edge="1" parent="WIyWlLk6GJQsqaUBKTNV-1" source="naoDOJTC9RyMsyCSktRx-0" target="SelwD84V-lnaNtGyxA-m-0">
          <mxGeometry relative="1" as="geometry" />
        </mxCell>
        <mxCell id="gvsdgywLlCYybCyVyM71-3" value="*" style="edgeLabel;html=1;align=center;verticalAlign=middle;resizable=0;points=[];fontSize=16;" vertex="1" connectable="0" parent="gvsdgywLlCYybCyVyM71-1">
          <mxGeometry x="0.8173" relative="1" as="geometry">
            <mxPoint y="-9" as="offset" />
          </mxGeometry>
        </mxCell>
        <mxCell id="naoDOJTC9RyMsyCSktRx-0" value="Gestor" style="swimlane;fontStyle=1;childLayout=stackLayout;horizontal=1;startSize=26;fillColor=none;horizontalStack=0;resizeParent=1;resizeParentMax=0;resizeLast=0;collapsible=1;marginBottom=0;fontSize=14;" parent="WIyWlLk6GJQsqaUBKTNV-1" vertex="1">
          <mxGeometry x="530" y="22" width="215" height="106" as="geometry" />
        </mxCell>
      </root>
    </mxGraphModel>
  </diagram>
</mxfile>
