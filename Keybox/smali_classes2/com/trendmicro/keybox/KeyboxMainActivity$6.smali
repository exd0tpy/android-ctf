.class Lcom/trendmicro/keybox/KeyboxMainActivity$6;
.super Ljava/lang/Object;
.source "KeyboxMainActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/trendmicro/keybox/KeyboxMainActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/trendmicro/keybox/KeyboxMainActivity;


# direct methods
.method constructor <init>(Lcom/trendmicro/keybox/KeyboxMainActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/trendmicro/keybox/KeyboxMainActivity;

    .line 217
    iput-object p1, p0, Lcom/trendmicro/keybox/KeyboxMainActivity$6;->this$0:Lcom/trendmicro/keybox/KeyboxMainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .line 219
    iget-object v0, p0, Lcom/trendmicro/keybox/KeyboxMainActivity$6;->this$0:Lcom/trendmicro/keybox/KeyboxMainActivity;

    invoke-virtual {v0, p1}, Lcom/trendmicro/keybox/KeyboxMainActivity;->GetFlag(Landroid/view/View;)V

    .line 220
    return-void
.end method
