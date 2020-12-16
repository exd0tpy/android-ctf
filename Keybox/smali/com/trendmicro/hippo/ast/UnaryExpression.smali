.class public Lcom/trendmicro/hippo/ast/UnaryExpression;
.super Lcom/trendmicro/hippo/ast/AstNode;
.source "UnaryExpression.java"


# instance fields
.field private isPostfix:Z

.field private operand:Lcom/trendmicro/hippo/ast/AstNode;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28
    invoke-direct {p0}, Lcom/trendmicro/hippo/ast/AstNode;-><init>()V

    .line 29
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "pos"    # I

    .line 32
    invoke-direct {p0, p1}, Lcom/trendmicro/hippo/ast/AstNode;-><init>(I)V

    .line 33
    return-void
.end method

.method public constructor <init>(II)V
    .locals 0
    .param p1, "pos"    # I
    .param p2, "len"    # I

    .line 39
    invoke-direct {p0, p1, p2}, Lcom/trendmicro/hippo/ast/AstNode;-><init>(II)V

    .line 40
    return-void
.end method

.method public constructor <init>(IILcom/trendmicro/hippo/ast/AstNode;)V
    .locals 1
    .param p1, "operator"    # I
    .param p2, "operatorPosition"    # I
    .param p3, "operand"    # Lcom/trendmicro/hippo/ast/AstNode;

    .line 47
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/trendmicro/hippo/ast/UnaryExpression;-><init>(IILcom/trendmicro/hippo/ast/AstNode;Z)V

    .line 48
    return-void
.end method

.method public constructor <init>(IILcom/trendmicro/hippo/ast/AstNode;Z)V
    .locals 3
    .param p1, "operator"    # I
    .param p2, "operatorPosition"    # I
    .param p3, "operand"    # Lcom/trendmicro/hippo/ast/AstNode;
    .param p4, "postFix"    # Z

    .line 61
    invoke-direct {p0}, Lcom/trendmicro/hippo/ast/AstNode;-><init>()V

    .line 62
    invoke-virtual {p0, p3}, Lcom/trendmicro/hippo/ast/UnaryExpression;->assertNotNull(Ljava/lang/Object;)V

    .line 63
    if-eqz p4, :cond_0

    invoke-virtual {p3}, Lcom/trendmicro/hippo/ast/AstNode;->getPosition()I

    move-result v0

    goto :goto_0

    :cond_0
    move v0, p2

    .line 65
    .local v0, "beg":I
    :goto_0
    if-eqz p4, :cond_1

    .line 66
    add-int/lit8 v1, p2, 0x2

    goto :goto_1

    .line 67
    :cond_1
    invoke-virtual {p3}, Lcom/trendmicro/hippo/ast/AstNode;->getPosition()I

    move-result v1

    invoke-virtual {p3}, Lcom/trendmicro/hippo/ast/AstNode;->getLength()I

    move-result v2

    add-int/2addr v1, v2

    :goto_1
    nop

    .line 68
    .local v1, "end":I
    invoke-virtual {p0, v0, v1}, Lcom/trendmicro/hippo/ast/UnaryExpression;->setBounds(II)V

    .line 69
    invoke-virtual {p0, p1}, Lcom/trendmicro/hippo/ast/UnaryExpression;->setOperator(I)V

    .line 70
    invoke-virtual {p0, p3}, Lcom/trendmicro/hippo/ast/UnaryExpression;->setOperand(Lcom/trendmicro/hippo/ast/AstNode;)V

    .line 71
    iput-boolean p4, p0, Lcom/trendmicro/hippo/ast/UnaryExpression;->isPostfix:Z

    .line 72
    return-void
.end method


# virtual methods
.method public getOperand()Lcom/trendmicro/hippo/ast/AstNode;
    .locals 1

    .line 94
    iget-object v0, p0, Lcom/trendmicro/hippo/ast/UnaryExpression;->operand:Lcom/trendmicro/hippo/ast/AstNode;

    return-object v0
.end method

.method public getOperator()I
    .locals 1

    .line 78
    iget v0, p0, Lcom/trendmicro/hippo/ast/UnaryExpression;->type:I

    return v0
.end method

.method public isPostfix()Z
    .locals 1

    .line 111
    iget-boolean v0, p0, Lcom/trendmicro/hippo/ast/UnaryExpression;->isPostfix:Z

    return v0
.end method

.method public isPrefix()Z
    .locals 1

    .line 118
    iget-boolean v0, p0, Lcom/trendmicro/hippo/ast/UnaryExpression;->isPostfix:Z

    xor-int/lit8 v0, v0, 0x1

    return v0
.end method

.method public setIsPostfix(Z)V
    .locals 0
    .param p1, "isPostfix"    # Z

    .line 125
    iput-boolean p1, p0, Lcom/trendmicro/hippo/ast/UnaryExpression;->isPostfix:Z

    .line 126
    return-void
.end method

.method public setOperand(Lcom/trendmicro/hippo/ast/AstNode;)V
    .locals 0
    .param p1, "operand"    # Lcom/trendmicro/hippo/ast/AstNode;

    .line 102
    invoke-virtual {p0, p1}, Lcom/trendmicro/hippo/ast/UnaryExpression;->assertNotNull(Ljava/lang/Object;)V

    .line 103
    iput-object p1, p0, Lcom/trendmicro/hippo/ast/UnaryExpression;->operand:Lcom/trendmicro/hippo/ast/AstNode;

    .line 104
    invoke-virtual {p1, p0}, Lcom/trendmicro/hippo/ast/AstNode;->setParent(Lcom/trendmicro/hippo/ast/AstNode;)V

    .line 105
    return-void
.end method

.method public setOperator(I)V
    .locals 3
    .param p1, "operator"    # I

    .line 88
    invoke-static {p1}, Lcom/trendmicro/hippo/Token;->isValidToken(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 90
    invoke-virtual {p0, p1}, Lcom/trendmicro/hippo/ast/UnaryExpression;->setType(I)Lcom/trendmicro/hippo/Node;

    .line 91
    return-void

    .line 89
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invalid token: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public toSource(I)Ljava/lang/String;
    .locals 3
    .param p1, "depth"    # I

    .line 130
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 131
    .local v0, "sb":Ljava/lang/StringBuilder;
    invoke-virtual {p0, p1}, Lcom/trendmicro/hippo/ast/UnaryExpression;->makeIndent(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 132
    invoke-virtual {p0}, Lcom/trendmicro/hippo/ast/UnaryExpression;->getType()I

    move-result v1

    .line 133
    .local v1, "type":I
    iget-boolean v2, p0, Lcom/trendmicro/hippo/ast/UnaryExpression;->isPostfix:Z

    if-nez v2, :cond_1

    .line 134
    invoke-static {v1}, Lcom/trendmicro/hippo/ast/UnaryExpression;->operatorToString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 135
    const/16 v2, 0x20

    if-eq v1, v2, :cond_0

    const/16 v2, 0x1f

    if-eq v1, v2, :cond_0

    const/16 v2, 0x7f

    if-ne v1, v2, :cond_1

    .line 136
    :cond_0
    const-string v2, " "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 139
    :cond_1
    iget-object v2, p0, Lcom/trendmicro/hippo/ast/UnaryExpression;->operand:Lcom/trendmicro/hippo/ast/AstNode;

    invoke-virtual {v2}, Lcom/trendmicro/hippo/ast/AstNode;->toSource()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 140
    iget-boolean v2, p0, Lcom/trendmicro/hippo/ast/UnaryExpression;->isPostfix:Z

    if-eqz v2, :cond_2

    .line 141
    invoke-static {v1}, Lcom/trendmicro/hippo/ast/UnaryExpression;->operatorToString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 143
    :cond_2
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public visit(Lcom/trendmicro/hippo/ast/NodeVisitor;)V
    .locals 1
    .param p1, "v"    # Lcom/trendmicro/hippo/ast/NodeVisitor;

    .line 151
    invoke-interface {p1, p0}, Lcom/trendmicro/hippo/ast/NodeVisitor;->visit(Lcom/trendmicro/hippo/ast/AstNode;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 152
    iget-object v0, p0, Lcom/trendmicro/hippo/ast/UnaryExpression;->operand:Lcom/trendmicro/hippo/ast/AstNode;

    invoke-virtual {v0, p1}, Lcom/trendmicro/hippo/ast/AstNode;->visit(Lcom/trendmicro/hippo/ast/NodeVisitor;)V

    .line 154
    :cond_0
    return-void
.end method
